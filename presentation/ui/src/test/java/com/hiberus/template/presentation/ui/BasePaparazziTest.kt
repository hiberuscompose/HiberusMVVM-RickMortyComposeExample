package com.hiberus.template.presentation.ui

import androidx.compose.runtime.Composable
import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.detectEnvironment
import com.android.ide.common.rendering.api.SessionParams.RenderingMode.SHRINK
import com.hiberus.template.core.common.entities.enums.ComponentType
import com.hiberus.template.presentation.ui.paparazzi.screen.samples.ButtonTest
import okio.IOException
import org.junit.Rule
import org.junit.Test
import java.io.File
import java.net.URI
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.util.Locale

abstract class BasePaparazziTest {

    @get:Rule
    val paparazzi = Paparazzi(
        theme = "",
        renderingMode = SHRINK,
        environment = detectEnvironment().run {
            copy(compileSdkVersion = 33, platformDir = platformDir.replace("34", "33"))
        },
    )

    private val os: Os? get() = getOS()
    private val projectPath =
        ButtonTest::class.java.getResource("")?.toURI()?.let { getOsFilePath(it) }
            ?.substringBefore("/$Presentation")
    private val directoryPath = projectPath.plus(getProjectPath())
    private val destinationPath = projectPath.plus(getDestinationPath())

    protected abstract val thumbnailData: Snapshot

    inner class Snapshot(val component: ComponentType, val composable: @Composable () -> Unit)

    @Test
    fun getBitmapFromComposeView() {
        paparazzi.snapshot(thumbnailData.component.thumbnail) {
            thumbnailData.composable.invoke()
        }
        renameAndMoveFirstPngInDirectory(
            directoryPath = directoryPath,
            destinationPath = destinationPath,
            newFileName = thumbnailData.component.thumbnail,
        )
    }

    private fun renameAndMoveFirstPngInDirectory(
        directoryPath: String,
        destinationPath: String,
        newFileName: String
    ) {
        val pngFile = getFirstPngInDirectory(directoryPath)
        val renamedFile = renameFile(pngFile, newFileName)
        moveFileToDirectory(renamedFile, destinationPath)
    }

    private fun getFirstPngInDirectory(directoryPath: String): File {
        val directory = File(directoryPath)

        if (!directory.isDirectory) {
            throw IllegalArgumentException("$directoryPath is not a valid directory.")
        }

        val pngFiles = directory.listFiles { file ->
            file.isFile && file.extension.equals(Png, ignoreCase = true)
        }

        return pngFiles?.firstOrNull()
            ?: throw NoSuchElementException("No PNG files found in the directory.")
    }

    private fun renameFile(file: File, newFileName: String): File {
        val newFile = File(file.parentFile, "$newFileName$Extension")

        if (!file.renameTo(newFile)) {
            throw IOException("Failed to rename file.")
        }

        return newFile
    }

    private fun moveFileToDirectory(file: File, destinationPath: String) {
        val destinationDirectory = File(destinationPath)

        if (!destinationDirectory.exists()) {
            if (!destinationDirectory.mkdirs()) {
                throw IOException("Failed to create destination directory.")
            }
        }

        if (!destinationDirectory.isDirectory) {
            throw IllegalArgumentException("$destinationPath is not a valid directory.")
        }

        val destinationFile = File(destinationDirectory, file.name).toPath()

        Files.move(file.toPath(), destinationFile, StandardCopyOption.REPLACE_EXISTING)
    }

    private fun getOsFilePath(uri: URI): String {
        return when (os) {
            Os.Windows -> getWindowsPath(uri)
            Os.Mac -> getMacPath(uri)
            else -> getMacPath(uri)
        }
    }

    private fun getOS(): Os? {
        val os = System.getProperty(OsName)?.lowercase(Locale.getDefault()).orEmpty()
        return when {
            os.contains(Windows) -> Os.Windows
            os.contains(Mac) -> Os.Mac
            else -> null
        }
    }

    private fun getWindowsPath(uri: URI): String {
        val path = File(uri).path
        return path.substringBefore(Presentation)
    }

    private fun getMacPath(uri: URI) = File(uri).path

    private fun getProjectPath(): String {
        return when (os) {
            Os.Windows -> ProjectPathWindows
            Os.Mac -> ProjectPathMac
            else -> ProjectPathMac
        }
    }

    private fun getDestinationPath(): String {
        return when (os) {
            Os.Windows -> DestinationPathWindows
            Os.Mac -> DestinationPathMac
            else -> DestinationPathMac
        }
    }

    companion object {
        private const val Png = "png"
        private const val Extension = ".$Png"
        private const val Windows = "win"
        private const val Mac = "mac"
        private const val OsName = "os.name"
        private const val Presentation = "presentation"
        private const val ProjectPathWindows =
            "\\presentation\\ui\\build\\reports\\paparazzi\\images"
        private const val ProjectPathMac = "/presentation/ui/build/reports/paparazzi/images"
        private const val DestinationPathWindows = "\\presentation\\ui\\src\\main\\res\\drawable"
        private const val DestinationPathMac = "/presentation/ui/src/main/res/drawable"
    }

    private enum class Os {
        Windows, Mac
    }
}
