package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final ComposeLibraryAccessors laccForComposeLibraryAccessors = new ComposeLibraryAccessors(owner);
    private final DeLibraryAccessors laccForDeLibraryAccessors = new DeLibraryAccessors(owner);
    private final IoLibraryAccessors laccForIoLibraryAccessors = new IoLibraryAccessors(owner);
    private final LifecycleLibraryAccessors laccForLifecycleLibraryAccessors = new LifecycleLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final UiLibraryAccessors laccForUiLibraryAccessors = new UiLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAppcompat() { return create("appcompat"); }

        /**
         * Creates a dependency provider for constraintlayout (androidx.constraintlayout:constraintlayout)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getConstraintlayout() { return create("constraintlayout"); }

        /**
         * Creates a dependency provider for junit (junit:junit)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() { return create("junit"); }

        /**
         * Creates a dependency provider for material (com.google.android.material:material)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() { return create("material"); }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() { return laccForAndroidxLibraryAccessors; }

    /**
     * Returns the group of libraries at com
     */
    public ComLibraryAccessors getCom() { return laccForComLibraryAccessors; }

    /**
     * Returns the group of libraries at compose
     */
    public ComposeLibraryAccessors getCompose() { return laccForComposeLibraryAccessors; }

    /**
     * Returns the group of libraries at de
     */
    public DeLibraryAccessors getDe() { return laccForDeLibraryAccessors; }

    /**
     * Returns the group of libraries at io
     */
    public IoLibraryAccessors getIo() { return laccForIoLibraryAccessors; }

    /**
     * Returns the group of libraries at lifecycle
     */
    public LifecycleLibraryAccessors getLifecycle() { return laccForLifecycleLibraryAccessors; }

    /**
     * Returns the group of libraries at org
     */
    public OrgLibraryAccessors getOrg() { return laccForOrgLibraryAccessors; }

    /**
     * Returns the group of libraries at ui
     */
    public UiLibraryAccessors getUi() { return laccForUiLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxArchLibraryAccessors laccForAndroidxArchLibraryAccessors = new AndroidxArchLibraryAccessors(owner);
        private final AndroidxBiometricLibraryAccessors laccForAndroidxBiometricLibraryAccessors = new AndroidxBiometricLibraryAccessors(owner);
        private final AndroidxComposeLibraryAccessors laccForAndroidxComposeLibraryAccessors = new AndroidxComposeLibraryAccessors(owner);
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxDatastoreLibraryAccessors laccForAndroidxDatastoreLibraryAccessors = new AndroidxDatastoreLibraryAccessors(owner);
        private final AndroidxEmoji2LibraryAccessors laccForAndroidxEmoji2LibraryAccessors = new AndroidxEmoji2LibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxNavigationLibraryAccessors laccForAndroidxNavigationLibraryAccessors = new AndroidxNavigationLibraryAccessors(owner);
        private final AndroidxPagingLibraryAccessors laccForAndroidxPagingLibraryAccessors = new AndroidxPagingLibraryAccessors(owner);
        private final AndroidxRoomLibraryAccessors laccForAndroidxRoomLibraryAccessors = new AndroidxRoomLibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for multidex (androidx.multidex:multidex)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMultidex() { return create("androidx.multidex"); }

        /**
         * Returns the group of libraries at androidx.activity
         */
        public AndroidxActivityLibraryAccessors getActivity() { return laccForAndroidxActivityLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.arch
         */
        public AndroidxArchLibraryAccessors getArch() { return laccForAndroidxArchLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.biometric
         */
        public AndroidxBiometricLibraryAccessors getBiometric() { return laccForAndroidxBiometricLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.compose
         */
        public AndroidxComposeLibraryAccessors getCompose() { return laccForAndroidxComposeLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.core
         */
        public AndroidxCoreLibraryAccessors getCore() { return laccForAndroidxCoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.datastore
         */
        public AndroidxDatastoreLibraryAccessors getDatastore() { return laccForAndroidxDatastoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.emoji2
         */
        public AndroidxEmoji2LibraryAccessors getEmoji2() { return laccForAndroidxEmoji2LibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.lifecycle
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() { return laccForAndroidxLifecycleLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.navigation
         */
        public AndroidxNavigationLibraryAccessors getNavigation() { return laccForAndroidxNavigationLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.paging
         */
        public AndroidxPagingLibraryAccessors getPaging() { return laccForAndroidxPagingLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.room
         */
        public AndroidxRoomLibraryAccessors getRoom() { return laccForAndroidxRoomLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test
         */
        public AndroidxTestLibraryAccessors getTest() { return laccForAndroidxTestLibraryAccessors; }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityActivityLibraryAccessors laccForAndroidxActivityActivityLibraryAccessors = new AndroidxActivityActivityLibraryAccessors(owner);

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.activity.activity
         */
        public AndroidxActivityActivityLibraryAccessors getActivity() { return laccForAndroidxActivityActivityLibraryAccessors; }

    }

    public static class AndroidxActivityActivityLibraryAccessors extends SubDependencyFactory {

        public AndroidxActivityActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.activity:activity-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.activity.activity.compose"); }

            /**
             * Creates a dependency provider for ktx (androidx.activity:activity-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.activity.activity.ktx"); }

    }

    public static class AndroidxArchLibraryAccessors extends SubDependencyFactory {
        private final AndroidxArchCoreLibraryAccessors laccForAndroidxArchCoreLibraryAccessors = new AndroidxArchCoreLibraryAccessors(owner);

        public AndroidxArchLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.arch.core
         */
        public AndroidxArchCoreLibraryAccessors getCore() { return laccForAndroidxArchCoreLibraryAccessors; }

    }

    public static class AndroidxArchCoreLibraryAccessors extends SubDependencyFactory {
        private final AndroidxArchCoreCoreLibraryAccessors laccForAndroidxArchCoreCoreLibraryAccessors = new AndroidxArchCoreCoreLibraryAccessors(owner);

        public AndroidxArchCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.arch.core.core
         */
        public AndroidxArchCoreCoreLibraryAccessors getCore() { return laccForAndroidxArchCoreCoreLibraryAccessors; }

    }

    public static class AndroidxArchCoreCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxArchCoreCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for common (androidx.arch.core:core-common)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCommon() { return create("androidx.arch.core.core.common"); }

            /**
             * Creates a dependency provider for runtime (androidx.arch.core:core-runtime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() { return create("androidx.arch.core.core.runtime"); }

            /**
             * Creates a dependency provider for testing (androidx.arch.core:core-testing)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTesting() { return create("androidx.arch.core.core.testing"); }

    }

    public static class AndroidxBiometricLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxBiometricBiometricLibraryAccessors laccForAndroidxBiometricBiometricLibraryAccessors = new AndroidxBiometricBiometricLibraryAccessors(owner);

        public AndroidxBiometricLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for biometric (androidx.biometric:biometric)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.biometric"); }

        /**
         * Returns the group of libraries at androidx.biometric.biometric
         */
        public AndroidxBiometricBiometricLibraryAccessors getBiometric() { return laccForAndroidxBiometricBiometricLibraryAccessors; }

    }

    public static class AndroidxBiometricBiometricLibraryAccessors extends SubDependencyFactory {

        public AndroidxBiometricBiometricLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.biometric:biometric-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.biometric.biometric.ktx"); }

    }

    public static class AndroidxComposeLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeAnimationLibraryAccessors laccForAndroidxComposeAnimationLibraryAccessors = new AndroidxComposeAnimationLibraryAccessors(owner);
        private final AndroidxComposeMaterialLibraryAccessors laccForAndroidxComposeMaterialLibraryAccessors = new AndroidxComposeMaterialLibraryAccessors(owner);
        private final AndroidxComposeUiLibraryAccessors laccForAndroidxComposeUiLibraryAccessors = new AndroidxComposeUiLibraryAccessors(owner);

        public AndroidxComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compiler (androidx.compose.compiler:compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() { return create("androidx.compose.compiler"); }

            /**
             * Creates a dependency provider for material3 (androidx.compose.material3:material3)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial3() { return create("androidx.compose.material3"); }

        /**
         * Returns the group of libraries at androidx.compose.animation
         */
        public AndroidxComposeAnimationLibraryAccessors getAnimation() { return laccForAndroidxComposeAnimationLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.compose.material
         */
        public AndroidxComposeMaterialLibraryAccessors getMaterial() { return laccForAndroidxComposeMaterialLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.compose.ui
         */
        public AndroidxComposeUiLibraryAccessors getUi() { return laccForAndroidxComposeUiLibraryAccessors; }

    }

    public static class AndroidxComposeAnimationLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxComposeAnimationAnimationLibraryAccessors laccForAndroidxComposeAnimationAnimationLibraryAccessors = new AndroidxComposeAnimationAnimationLibraryAccessors(owner);

        public AndroidxComposeAnimationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for animation (androidx.compose.animation:animation)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.compose.animation"); }

        /**
         * Returns the group of libraries at androidx.compose.animation.animation
         */
        public AndroidxComposeAnimationAnimationLibraryAccessors getAnimation() { return laccForAndroidxComposeAnimationAnimationLibraryAccessors; }

    }

    public static class AndroidxComposeAnimationAnimationLibraryAccessors extends SubDependencyFactory {

        public AndroidxComposeAnimationAnimationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.compose.animation:animation-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx.compose.animation.animation.core"); }

            /**
             * Creates a dependency provider for graphics (androidx.compose.animation:animation-graphics)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGraphics() { return create("androidx.compose.animation.animation.graphics"); }

    }

    public static class AndroidxComposeMaterialLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeMaterialMaterialLibraryAccessors laccForAndroidxComposeMaterialMaterialLibraryAccessors = new AndroidxComposeMaterialMaterialLibraryAccessors(owner);

        public AndroidxComposeMaterialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.compose.material.material
         */
        public AndroidxComposeMaterialMaterialLibraryAccessors getMaterial() { return laccForAndroidxComposeMaterialMaterialLibraryAccessors; }

    }

    public static class AndroidxComposeMaterialMaterialLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeMaterialMaterialIconsLibraryAccessors laccForAndroidxComposeMaterialMaterialIconsLibraryAccessors = new AndroidxComposeMaterialMaterialIconsLibraryAccessors(owner);

        public AndroidxComposeMaterialMaterialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.compose.material.material.icons
         */
        public AndroidxComposeMaterialMaterialIconsLibraryAccessors getIcons() { return laccForAndroidxComposeMaterialMaterialIconsLibraryAccessors; }

    }

    public static class AndroidxComposeMaterialMaterialIconsLibraryAccessors extends SubDependencyFactory {

        public AndroidxComposeMaterialMaterialIconsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for extended (androidx.compose.material:material-icons-extended)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExtended() { return create("androidx.compose.material.material.icons.extended"); }

    }

    public static class AndroidxComposeUiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxComposeUiUiLibraryAccessors laccForAndroidxComposeUiUiLibraryAccessors = new AndroidxComposeUiUiLibraryAccessors(owner);

        public AndroidxComposeUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (androidx.compose.ui:ui)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.compose.ui"); }

            /**
             * Creates a dependency provider for constraintlayout (androidx.constraintlayout:constraintlayout-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConstraintlayout() { return create("androidx.compose.ui.constraintlayout"); }

            /**
             * Creates a dependency provider for graphics (androidx.compose.ui:ui-graphics)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGraphics() { return create("androidx.compose.ui.graphics"); }

        /**
         * Returns the group of libraries at androidx.compose.ui.ui
         */
        public AndroidxComposeUiUiLibraryAccessors getUi() { return laccForAndroidxComposeUiUiLibraryAccessors; }

    }

    public static class AndroidxComposeUiUiLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeUiUiToolingLibraryAccessors laccForAndroidxComposeUiUiToolingLibraryAccessors = new AndroidxComposeUiUiToolingLibraryAccessors(owner);

        public AndroidxComposeUiUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.compose.ui.ui.tooling
         */
        public AndroidxComposeUiUiToolingLibraryAccessors getTooling() { return laccForAndroidxComposeUiUiToolingLibraryAccessors; }

    }

    public static class AndroidxComposeUiUiToolingLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxComposeUiUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for tooling (androidx.compose.ui:ui-tooling)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.compose.ui.ui.tooling"); }

            /**
             * Creates a dependency provider for preview (androidx.compose.ui:ui-tooling-preview)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPreview() { return create("androidx.compose.ui.ui.tooling.preview"); }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {
        private final AndroidxCoreCoreLibraryAccessors laccForAndroidxCoreCoreLibraryAccessors = new AndroidxCoreCoreLibraryAccessors(owner);

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.core.core
         */
        public AndroidxCoreCoreLibraryAccessors getCore() { return laccForAndroidxCoreCoreLibraryAccessors; }

    }

    public static class AndroidxCoreCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.core.core.ktx"); }

            /**
             * Creates a dependency provider for splashscreen (androidx.core:core-splashscreen)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSplashscreen() { return create("androidx.core.core.splashscreen"); }

    }

    public static class AndroidxDatastoreLibraryAccessors extends SubDependencyFactory {
        private final AndroidxDatastoreDatastoreLibraryAccessors laccForAndroidxDatastoreDatastoreLibraryAccessors = new AndroidxDatastoreDatastoreLibraryAccessors(owner);

        public AndroidxDatastoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.datastore.datastore
         */
        public AndroidxDatastoreDatastoreLibraryAccessors getDatastore() { return laccForAndroidxDatastoreDatastoreLibraryAccessors; }

    }

    public static class AndroidxDatastoreDatastoreLibraryAccessors extends SubDependencyFactory {
        private final AndroidxDatastoreDatastorePreferencesLibraryAccessors laccForAndroidxDatastoreDatastorePreferencesLibraryAccessors = new AndroidxDatastoreDatastorePreferencesLibraryAccessors(owner);

        public AndroidxDatastoreDatastoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.datastore.datastore.preferences
         */
        public AndroidxDatastoreDatastorePreferencesLibraryAccessors getPreferences() { return laccForAndroidxDatastoreDatastorePreferencesLibraryAccessors; }

    }

    public static class AndroidxDatastoreDatastorePreferencesLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxDatastoreDatastorePreferencesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for preferences (androidx.datastore:datastore-preferences)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.datastore.datastore.preferences"); }

            /**
             * Creates a dependency provider for core (androidx.datastore:datastore-preferences-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx.datastore.datastore.preferences.core"); }

    }

    public static class AndroidxEmoji2LibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxEmoji2ViewsLibraryAccessors laccForAndroidxEmoji2ViewsLibraryAccessors = new AndroidxEmoji2ViewsLibraryAccessors(owner);

        public AndroidxEmoji2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for emoji2 (androidx.emoji2:emoji2)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.emoji2"); }

        /**
         * Returns the group of libraries at androidx.emoji2.views
         */
        public AndroidxEmoji2ViewsLibraryAccessors getViews() { return laccForAndroidxEmoji2ViewsLibraryAccessors; }

    }

    public static class AndroidxEmoji2ViewsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxEmoji2ViewsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for views (androidx.emoji2:emoji2-views)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.emoji2.views"); }

            /**
             * Creates a dependency provider for helper (androidx.emoji2:emoji2-views-helper)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getHelper() { return create("androidx.emoji2.views.helper"); }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleLifecycleLibraryAccessors laccForAndroidxLifecycleLifecycleLibraryAccessors = new AndroidxLifecycleLifecycleLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.lifecycle.lifecycle
         */
        public AndroidxLifecycleLifecycleLibraryAccessors getLifecycle() { return laccForAndroidxLifecycleLifecycleLibraryAccessors; }

    }

    public static class AndroidxLifecycleLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleLifecycleViewmodelLibraryAccessors laccForAndroidxLifecycleLifecycleViewmodelLibraryAccessors = new AndroidxLifecycleLifecycleViewmodelLibraryAccessors(owner);

        public AndroidxLifecycleLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for extensions (androidx.lifecycle:lifecycle-extensions)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExtensions() { return create("androidx.lifecycle.lifecycle.extensions"); }

            /**
             * Creates a dependency provider for service (androidx.lifecycle:lifecycle-service)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getService() { return create("androidx.lifecycle.lifecycle.service"); }

        /**
         * Returns the group of libraries at androidx.lifecycle.lifecycle.viewmodel
         */
        public AndroidxLifecycleLifecycleViewmodelLibraryAccessors getViewmodel() { return laccForAndroidxLifecycleLifecycleViewmodelLibraryAccessors; }

    }

    public static class AndroidxLifecycleLifecycleViewmodelLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleLifecycleViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.lifecycle:lifecycle-runtime-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.lifecycle.lifecycle.viewmodel.compose"); }

            /**
             * Creates a dependency provider for ktx (androidx.lifecycle:lifecycle-viewmodel-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.lifecycle.lifecycle.viewmodel.ktx"); }

    }

    public static class AndroidxNavigationLibraryAccessors extends SubDependencyFactory {
        private final AndroidxNavigationNavigationLibraryAccessors laccForAndroidxNavigationNavigationLibraryAccessors = new AndroidxNavigationNavigationLibraryAccessors(owner);

        public AndroidxNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.navigation.navigation
         */
        public AndroidxNavigationNavigationLibraryAccessors getNavigation() { return laccForAndroidxNavigationNavigationLibraryAccessors; }

    }

    public static class AndroidxNavigationNavigationLibraryAccessors extends SubDependencyFactory {

        public AndroidxNavigationNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.navigation:navigation-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.navigation.navigation.compose"); }

    }

    public static class AndroidxPagingLibraryAccessors extends SubDependencyFactory {
        private final AndroidxPagingPagingLibraryAccessors laccForAndroidxPagingPagingLibraryAccessors = new AndroidxPagingPagingLibraryAccessors(owner);

        public AndroidxPagingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.paging:paging-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.paging.compose"); }

        /**
         * Returns the group of libraries at androidx.paging.paging
         */
        public AndroidxPagingPagingLibraryAccessors getPaging() { return laccForAndroidxPagingPagingLibraryAccessors; }

    }

    public static class AndroidxPagingPagingLibraryAccessors extends SubDependencyFactory {
        private final AndroidxPagingPagingRuntimeLibraryAccessors laccForAndroidxPagingPagingRuntimeLibraryAccessors = new AndroidxPagingPagingRuntimeLibraryAccessors(owner);

        public AndroidxPagingPagingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.paging.paging.runtime
         */
        public AndroidxPagingPagingRuntimeLibraryAccessors getRuntime() { return laccForAndroidxPagingPagingRuntimeLibraryAccessors; }

    }

    public static class AndroidxPagingPagingRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxPagingPagingRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.paging:paging-runtime-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.paging.paging.runtime.ktx"); }

    }

    public static class AndroidxRoomLibraryAccessors extends SubDependencyFactory {
        private final AndroidxRoomRoomLibraryAccessors laccForAndroidxRoomRoomLibraryAccessors = new AndroidxRoomRoomLibraryAccessors(owner);

        public AndroidxRoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.room.room
         */
        public AndroidxRoomRoomLibraryAccessors getRoom() { return laccForAndroidxRoomRoomLibraryAccessors; }

    }

    public static class AndroidxRoomRoomLibraryAccessors extends SubDependencyFactory {

        public AndroidxRoomRoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compiler (androidx.room:room-compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() { return create("androidx.room.room.compiler"); }

            /**
             * Creates a dependency provider for ktx (androidx.room:room-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.room.room.ktx"); }

            /**
             * Creates a dependency provider for runtime (androidx.room:room-runtime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() { return create("androidx.room.room.runtime"); }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {
        private final AndroidxTestCoreLibraryAccessors laccForAndroidxTestCoreLibraryAccessors = new AndroidxTestCoreLibraryAccessors(owner);
        private final AndroidxTestEspressoLibraryAccessors laccForAndroidxTestEspressoLibraryAccessors = new AndroidxTestEspressoLibraryAccessors(owner);
        private final AndroidxTestExtLibraryAccessors laccForAndroidxTestExtLibraryAccessors = new AndroidxTestExtLibraryAccessors(owner);

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for runner (androidx.test:runner)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRunner() { return create("androidx.test.runner"); }

        /**
         * Returns the group of libraries at androidx.test.core
         */
        public AndroidxTestCoreLibraryAccessors getCore() { return laccForAndroidxTestCoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test.espresso
         */
        public AndroidxTestEspressoLibraryAccessors getEspresso() { return laccForAndroidxTestEspressoLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test.ext
         */
        public AndroidxTestExtLibraryAccessors getExt() { return laccForAndroidxTestExtLibraryAccessors; }

    }

    public static class AndroidxTestCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.test:core-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.test.core.ktx"); }

    }

    public static class AndroidxTestEspressoLibraryAccessors extends SubDependencyFactory {
        private final AndroidxTestEspressoEspressoLibraryAccessors laccForAndroidxTestEspressoEspressoLibraryAccessors = new AndroidxTestEspressoEspressoLibraryAccessors(owner);

        public AndroidxTestEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.test.espresso.espresso
         */
        public AndroidxTestEspressoEspressoLibraryAccessors getEspresso() { return laccForAndroidxTestEspressoEspressoLibraryAccessors; }

    }

    public static class AndroidxTestEspressoEspressoLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestEspressoEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for contrib (androidx.test.espresso:espresso-contrib)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getContrib() { return create("androidx.test.espresso.espresso.contrib"); }

            /**
             * Creates a dependency provider for core (androidx.test.espresso:espresso-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx.test.espresso.espresso.core"); }

    }

    public static class AndroidxTestExtLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (androidx.test.ext:junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("androidx.test.ext.junit"); }

    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComAgodaLibraryAccessors laccForComAgodaLibraryAccessors = new ComAgodaLibraryAccessors(owner);
        private final ComAndroidLibraryAccessors laccForComAndroidLibraryAccessors = new ComAndroidLibraryAccessors(owner);
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);
        private final ComJakewhartonLibraryAccessors laccForComJakewhartonLibraryAccessors = new ComJakewhartonLibraryAccessors(owner);
        private final ComSquareupLibraryAccessors laccForComSquareupLibraryAccessors = new ComSquareupLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.agoda
         */
        public ComAgodaLibraryAccessors getAgoda() { return laccForComAgodaLibraryAccessors; }

        /**
         * Returns the group of libraries at com.android
         */
        public ComAndroidLibraryAccessors getAndroid() { return laccForComAndroidLibraryAccessors; }

        /**
         * Returns the group of libraries at com.google
         */
        public ComGoogleLibraryAccessors getGoogle() { return laccForComGoogleLibraryAccessors; }

        /**
         * Returns the group of libraries at com.jakewharton
         */
        public ComJakewhartonLibraryAccessors getJakewharton() { return laccForComJakewhartonLibraryAccessors; }

        /**
         * Returns the group of libraries at com.squareup
         */
        public ComSquareupLibraryAccessors getSquareup() { return laccForComSquareupLibraryAccessors; }

    }

    public static class ComAgodaLibraryAccessors extends SubDependencyFactory {

        public ComAgodaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for kakao (com.agoda.kakao:kakao)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKakao() { return create("com.agoda.kakao"); }

    }

    public static class ComAndroidLibraryAccessors extends SubDependencyFactory {
        private final ComAndroidToolsLibraryAccessors laccForComAndroidToolsLibraryAccessors = new ComAndroidToolsLibraryAccessors(owner);

        public ComAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.android.tools
         */
        public ComAndroidToolsLibraryAccessors getTools() { return laccForComAndroidToolsLibraryAccessors; }

    }

    public static class ComAndroidToolsLibraryAccessors extends SubDependencyFactory {
        private final ComAndroidToolsDesugarLibraryAccessors laccForComAndroidToolsDesugarLibraryAccessors = new ComAndroidToolsDesugarLibraryAccessors(owner);

        public ComAndroidToolsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.android.tools.desugar
         */
        public ComAndroidToolsDesugarLibraryAccessors getDesugar() { return laccForComAndroidToolsDesugarLibraryAccessors; }

    }

    public static class ComAndroidToolsDesugarLibraryAccessors extends SubDependencyFactory {
        private final ComAndroidToolsDesugarJdkLibraryAccessors laccForComAndroidToolsDesugarJdkLibraryAccessors = new ComAndroidToolsDesugarJdkLibraryAccessors(owner);

        public ComAndroidToolsDesugarLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.android.tools.desugar.jdk
         */
        public ComAndroidToolsDesugarJdkLibraryAccessors getJdk() { return laccForComAndroidToolsDesugarJdkLibraryAccessors; }

    }

    public static class ComAndroidToolsDesugarJdkLibraryAccessors extends SubDependencyFactory {

        public ComAndroidToolsDesugarJdkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for libs (com.android.tools:desugar_jdk_libs)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLibs() { return create("com.android.tools.desugar.jdk.libs"); }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAccompanistLibraryAccessors laccForComGoogleAccompanistLibraryAccessors = new ComGoogleAccompanistLibraryAccessors(owner);
        private final ComGoogleCodeLibraryAccessors laccForComGoogleCodeLibraryAccessors = new ComGoogleCodeLibraryAccessors(owner);
        private final ComGoogleDaggerLibraryAccessors laccForComGoogleDaggerLibraryAccessors = new ComGoogleDaggerLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.accompanist
         */
        public ComGoogleAccompanistLibraryAccessors getAccompanist() { return laccForComGoogleAccompanistLibraryAccessors; }

        /**
         * Returns the group of libraries at com.google.code
         */
        public ComGoogleCodeLibraryAccessors getCode() { return laccForComGoogleCodeLibraryAccessors; }

        /**
         * Returns the group of libraries at com.google.dagger
         */
        public ComGoogleDaggerLibraryAccessors getDagger() { return laccForComGoogleDaggerLibraryAccessors; }

    }

    public static class ComGoogleAccompanistLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAccompanistAccompanistLibraryAccessors laccForComGoogleAccompanistAccompanistLibraryAccessors = new ComGoogleAccompanistAccompanistLibraryAccessors(owner);

        public ComGoogleAccompanistLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.accompanist.accompanist
         */
        public ComGoogleAccompanistAccompanistLibraryAccessors getAccompanist() { return laccForComGoogleAccompanistAccompanistLibraryAccessors; }

    }

    public static class ComGoogleAccompanistAccompanistLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAccompanistAccompanistNavigationLibraryAccessors laccForComGoogleAccompanistAccompanistNavigationLibraryAccessors = new ComGoogleAccompanistAccompanistNavigationLibraryAccessors(owner);
        private final ComGoogleAccompanistAccompanistPagerLibraryAccessors laccForComGoogleAccompanistAccompanistPagerLibraryAccessors = new ComGoogleAccompanistAccompanistPagerLibraryAccessors(owner);

        public ComGoogleAccompanistAccompanistLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for permissions (com.google.accompanist:accompanist-permissions)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPermissions() { return create("com.google.accompanist.accompanist.permissions"); }

            /**
             * Creates a dependency provider for swiperefresh (com.google.accompanist:accompanist-swiperefresh)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSwiperefresh() { return create("com.google.accompanist.accompanist.swiperefresh"); }

        /**
         * Returns the group of libraries at com.google.accompanist.accompanist.navigation
         */
        public ComGoogleAccompanistAccompanistNavigationLibraryAccessors getNavigation() { return laccForComGoogleAccompanistAccompanistNavigationLibraryAccessors; }

        /**
         * Returns the group of libraries at com.google.accompanist.accompanist.pager
         */
        public ComGoogleAccompanistAccompanistPagerLibraryAccessors getPager() { return laccForComGoogleAccompanistAccompanistPagerLibraryAccessors; }

    }

    public static class ComGoogleAccompanistAccompanistNavigationLibraryAccessors extends SubDependencyFactory {

        public ComGoogleAccompanistAccompanistNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for animation (com.google.accompanist:accompanist-navigation-animation)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAnimation() { return create("com.google.accompanist.accompanist.navigation.animation"); }

    }

    public static class ComGoogleAccompanistAccompanistPagerLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ComGoogleAccompanistAccompanistPagerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for pager (com.google.accompanist:accompanist-pager)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("com.google.accompanist.accompanist.pager"); }

            /**
             * Creates a dependency provider for indicators (com.google.accompanist:accompanist-pager-indicators)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getIndicators() { return create("com.google.accompanist.accompanist.pager.indicators"); }

    }

    public static class ComGoogleCodeLibraryAccessors extends SubDependencyFactory {

        public ComGoogleCodeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gson (com.google.code.gson:gson)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGson() { return create("com.google.code.gson"); }

    }

    public static class ComGoogleDaggerLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDaggerHiltLibraryAccessors laccForComGoogleDaggerHiltLibraryAccessors = new ComGoogleDaggerHiltLibraryAccessors(owner);

        public ComGoogleDaggerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.dagger.hilt
         */
        public ComGoogleDaggerHiltLibraryAccessors getHilt() { return laccForComGoogleDaggerHiltLibraryAccessors; }

    }

    public static class ComGoogleDaggerHiltLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDaggerHiltAndroidLibraryAccessors laccForComGoogleDaggerHiltAndroidLibraryAccessors = new ComGoogleDaggerHiltAndroidLibraryAccessors(owner);

        public ComGoogleDaggerHiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.hilt:hilt-navigation-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("com.google.dagger.hilt.compose"); }

        /**
         * Returns the group of libraries at com.google.dagger.hilt.android
         */
        public ComGoogleDaggerHiltAndroidLibraryAccessors getAndroid() { return laccForComGoogleDaggerHiltAndroidLibraryAccessors; }

    }

    public static class ComGoogleDaggerHiltAndroidLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ComGoogleDaggerHiltAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (com.google.dagger:hilt-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("com.google.dagger.hilt.android"); }

            /**
             * Creates a dependency provider for compiler (com.google.dagger:hilt-android-compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() { return create("com.google.dagger.hilt.android.compiler"); }

    }

    public static class ComJakewhartonLibraryAccessors extends SubDependencyFactory {

        public ComJakewhartonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for timber (com.jakewharton.timber:timber)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTimber() { return create("com.jakewharton.timber"); }

    }

    public static class ComSquareupLibraryAccessors extends SubDependencyFactory {
        private final ComSquareupMoshiLibraryAccessors laccForComSquareupMoshiLibraryAccessors = new ComSquareupMoshiLibraryAccessors(owner);
        private final ComSquareupOkhttp3LibraryAccessors laccForComSquareupOkhttp3LibraryAccessors = new ComSquareupOkhttp3LibraryAccessors(owner);
        private final ComSquareupRetrofit2LibraryAccessors laccForComSquareupRetrofit2LibraryAccessors = new ComSquareupRetrofit2LibraryAccessors(owner);

        public ComSquareupLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.squareup.moshi
         */
        public ComSquareupMoshiLibraryAccessors getMoshi() { return laccForComSquareupMoshiLibraryAccessors; }

        /**
         * Returns the group of libraries at com.squareup.okhttp3
         */
        public ComSquareupOkhttp3LibraryAccessors getOkhttp3() { return laccForComSquareupOkhttp3LibraryAccessors; }

        /**
         * Returns the group of libraries at com.squareup.retrofit2
         */
        public ComSquareupRetrofit2LibraryAccessors getRetrofit2() { return laccForComSquareupRetrofit2LibraryAccessors; }

    }

    public static class ComSquareupMoshiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ComSquareupMoshiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for moshi (com.squareup.moshi:moshi-kotlin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("com.squareup.moshi"); }

            /**
             * Creates a dependency provider for adapters (com.squareup.moshi:moshi-adapters)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAdapters() { return create("com.squareup.moshi.adapters"); }

            /**
             * Creates a dependency provider for codegen (com.squareup.moshi:moshi-kotlin-codegen)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCodegen() { return create("com.squareup.moshi.codegen"); }

    }

    public static class ComSquareupOkhttp3LibraryAccessors extends SubDependencyFactory {
        private final ComSquareupOkhttp3LoggingLibraryAccessors laccForComSquareupOkhttp3LoggingLibraryAccessors = new ComSquareupOkhttp3LoggingLibraryAccessors(owner);

        public ComSquareupOkhttp3LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.squareup.okhttp3.logging
         */
        public ComSquareupOkhttp3LoggingLibraryAccessors getLogging() { return laccForComSquareupOkhttp3LoggingLibraryAccessors; }

    }

    public static class ComSquareupOkhttp3LoggingLibraryAccessors extends SubDependencyFactory {

        public ComSquareupOkhttp3LoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for interceptor (com.squareup.okhttp3:logging-interceptor)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getInterceptor() { return create("com.squareup.okhttp3.logging.interceptor"); }

    }

    public static class ComSquareupRetrofit2LibraryAccessors extends SubDependencyFactory {
        private final ComSquareupRetrofit2ConverterLibraryAccessors laccForComSquareupRetrofit2ConverterLibraryAccessors = new ComSquareupRetrofit2ConverterLibraryAccessors(owner);

        public ComSquareupRetrofit2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for retrofit (com.squareup.retrofit2:retrofit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRetrofit() { return create("com.squareup.retrofit2.retrofit"); }

        /**
         * Returns the group of libraries at com.squareup.retrofit2.converter
         */
        public ComSquareupRetrofit2ConverterLibraryAccessors getConverter() { return laccForComSquareupRetrofit2ConverterLibraryAccessors; }

    }

    public static class ComSquareupRetrofit2ConverterLibraryAccessors extends SubDependencyFactory {

        public ComSquareupRetrofit2ConverterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gson (com.squareup.retrofit2:converter-gson)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGson() { return create("com.squareup.retrofit2.converter.gson"); }

    }

    public static class ComposeLibraryAccessors extends SubDependencyFactory {

        public ComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for bom (androidx.compose:compose-bom)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBom() { return create("compose.bom"); }

    }

    public static class DeLibraryAccessors extends SubDependencyFactory {
        private final DeMannodermausLibraryAccessors laccForDeMannodermausLibraryAccessors = new DeMannodermausLibraryAccessors(owner);

        public DeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at de.mannodermaus
         */
        public DeMannodermausLibraryAccessors getMannodermaus() { return laccForDeMannodermausLibraryAccessors; }

    }

    public static class DeMannodermausLibraryAccessors extends SubDependencyFactory {
        private final DeMannodermausJunit5LibraryAccessors laccForDeMannodermausJunit5LibraryAccessors = new DeMannodermausJunit5LibraryAccessors(owner);

        public DeMannodermausLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at de.mannodermaus.junit5
         */
        public DeMannodermausJunit5LibraryAccessors getJunit5() { return laccForDeMannodermausJunit5LibraryAccessors; }

    }

    public static class DeMannodermausJunit5LibraryAccessors extends SubDependencyFactory {
        private final DeMannodermausJunit5AndroidLibraryAccessors laccForDeMannodermausJunit5AndroidLibraryAccessors = new DeMannodermausJunit5AndroidLibraryAccessors(owner);

        public DeMannodermausJunit5LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at de.mannodermaus.junit5.android
         */
        public DeMannodermausJunit5AndroidLibraryAccessors getAndroid() { return laccForDeMannodermausJunit5AndroidLibraryAccessors; }

    }

    public static class DeMannodermausJunit5AndroidLibraryAccessors extends SubDependencyFactory {
        private final DeMannodermausJunit5AndroidTestLibraryAccessors laccForDeMannodermausJunit5AndroidTestLibraryAccessors = new DeMannodermausJunit5AndroidTestLibraryAccessors(owner);

        public DeMannodermausJunit5AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at de.mannodermaus.junit5.android.test
         */
        public DeMannodermausJunit5AndroidTestLibraryAccessors getTest() { return laccForDeMannodermausJunit5AndroidTestLibraryAccessors; }

    }

    public static class DeMannodermausJunit5AndroidTestLibraryAccessors extends SubDependencyFactory {

        public DeMannodermausJunit5AndroidTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (de.mannodermaus.junit5:android-test-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("de.mannodermaus.junit5.android.test.core"); }

            /**
             * Creates a dependency provider for runner (de.mannodermaus.junit5:android-test-runner)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRunner() { return create("de.mannodermaus.junit5.android.test.runner"); }

    }

    public static class IoLibraryAccessors extends SubDependencyFactory {
        private final IoCoilLibraryAccessors laccForIoCoilLibraryAccessors = new IoCoilLibraryAccessors(owner);

        public IoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for mockk (io.mockk:mockk)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMockk() { return create("io.mockk"); }

        /**
         * Returns the group of libraries at io.coil
         */
        public IoCoilLibraryAccessors getCoil() { return laccForIoCoilLibraryAccessors; }

    }

    public static class IoCoilLibraryAccessors extends SubDependencyFactory {
        private final IoCoilKtLibraryAccessors laccForIoCoilKtLibraryAccessors = new IoCoilKtLibraryAccessors(owner);

        public IoCoilLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.coil.kt
         */
        public IoCoilKtLibraryAccessors getKt() { return laccForIoCoilKtLibraryAccessors; }

    }

    public static class IoCoilKtLibraryAccessors extends SubDependencyFactory {
        private final IoCoilKtCoilLibraryAccessors laccForIoCoilKtCoilLibraryAccessors = new IoCoilKtCoilLibraryAccessors(owner);

        public IoCoilKtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.coil.kt.coil
         */
        public IoCoilKtCoilLibraryAccessors getCoil() { return laccForIoCoilKtCoilLibraryAccessors; }

    }

    public static class IoCoilKtCoilLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final IoCoilKtCoilComposeLibraryAccessors laccForIoCoilKtCoilComposeLibraryAccessors = new IoCoilKtCoilComposeLibraryAccessors(owner);

        public IoCoilKtCoilLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for coil (io.coil-kt:coil)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("io.coil.kt.coil"); }

            /**
             * Creates a dependency provider for base (io.coil-kt:coil-base)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBase() { return create("io.coil.kt.coil.base"); }

            /**
             * Creates a dependency provider for gif (io.coil-kt:coil-gif)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGif() { return create("io.coil.kt.coil.gif"); }

            /**
             * Creates a dependency provider for svg (io.coil-kt:coil-svg)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSvg() { return create("io.coil.kt.coil.svg"); }

        /**
         * Returns the group of libraries at io.coil.kt.coil.compose
         */
        public IoCoilKtCoilComposeLibraryAccessors getCompose() { return laccForIoCoilKtCoilComposeLibraryAccessors; }

    }

    public static class IoCoilKtCoilComposeLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public IoCoilKtCoilComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (io.coil-kt:coil-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("io.coil.kt.coil.compose"); }

            /**
             * Creates a dependency provider for base (io.coil-kt:coil-compose-base)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBase() { return create("io.coil.kt.coil.compose.base"); }

    }

    public static class LifecycleLibraryAccessors extends SubDependencyFactory {
        private final LifecycleRuntimeLibraryAccessors laccForLifecycleRuntimeLibraryAccessors = new LifecycleRuntimeLibraryAccessors(owner);

        public LifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at lifecycle.runtime
         */
        public LifecycleRuntimeLibraryAccessors getRuntime() { return laccForLifecycleRuntimeLibraryAccessors; }

    }

    public static class LifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public LifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.lifecycle:lifecycle-runtime-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("lifecycle.runtime.ktx"); }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgAmshoveLibraryAccessors laccForOrgAmshoveLibraryAccessors = new OrgAmshoveLibraryAccessors(owner);
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgJetbrainsLibraryAccessors laccForOrgJetbrainsLibraryAccessors = new OrgJetbrainsLibraryAccessors(owner);
        private final OrgJunitLibraryAccessors laccForOrgJunitLibraryAccessors = new OrgJunitLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for robolectric (org.robolectric:robolectric)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRobolectric() { return create("org.robolectric"); }

        /**
         * Returns the group of libraries at org.amshove
         */
        public OrgAmshoveLibraryAccessors getAmshove() { return laccForOrgAmshoveLibraryAccessors; }

        /**
         * Returns the group of libraries at org.apache
         */
        public OrgApacheLibraryAccessors getApache() { return laccForOrgApacheLibraryAccessors; }

        /**
         * Returns the group of libraries at org.jetbrains
         */
        public OrgJetbrainsLibraryAccessors getJetbrains() { return laccForOrgJetbrainsLibraryAccessors; }

        /**
         * Returns the group of libraries at org.junit
         */
        public OrgJunitLibraryAccessors getJunit() { return laccForOrgJunitLibraryAccessors; }

    }

    public static class OrgAmshoveLibraryAccessors extends SubDependencyFactory {
        private final OrgAmshoveKluentLibraryAccessors laccForOrgAmshoveKluentLibraryAccessors = new OrgAmshoveKluentLibraryAccessors(owner);

        public OrgAmshoveLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.amshove.kluent
         */
        public OrgAmshoveKluentLibraryAccessors getKluent() { return laccForOrgAmshoveKluentLibraryAccessors; }

    }

    public static class OrgAmshoveKluentLibraryAccessors extends SubDependencyFactory {
        private final OrgAmshoveKluentKluentLibraryAccessors laccForOrgAmshoveKluentKluentLibraryAccessors = new OrgAmshoveKluentKluentLibraryAccessors(owner);

        public OrgAmshoveKluentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.amshove.kluent.kluent
         */
        public OrgAmshoveKluentKluentLibraryAccessors getKluent() { return laccForOrgAmshoveKluentKluentLibraryAccessors; }

    }

    public static class OrgAmshoveKluentKluentLibraryAccessors extends SubDependencyFactory {

        public OrgAmshoveKluentKluentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (org.amshove.kluent:kluent-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("org.amshove.kluent.kluent.android"); }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLibraryAccessors laccForOrgApacheLoggingLibraryAccessors = new OrgApacheLoggingLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.logging
         */
        public OrgApacheLoggingLibraryAccessors getLogging() { return laccForOrgApacheLoggingLibraryAccessors; }

    }

    public static class OrgApacheLoggingLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLibraryAccessors = new OrgApacheLoggingLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.logging.log4j
         */
        public OrgApacheLoggingLog4jLibraryAccessors getLog4j() { return laccForOrgApacheLoggingLog4jLibraryAccessors; }

    }

    public static class OrgApacheLoggingLog4jLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLog4jLibraryAccessors = new OrgApacheLoggingLog4jLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.logging.log4j.log4j
         */
        public OrgApacheLoggingLog4jLog4jLibraryAccessors getLog4j() { return laccForOrgApacheLoggingLog4jLog4jLibraryAccessors; }

    }

    public static class OrgApacheLoggingLog4jLog4jLibraryAccessors extends SubDependencyFactory {

        public OrgApacheLoggingLog4jLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.apache.logging.log4j:log4j-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("org.apache.logging.log4j.log4j.core"); }

    }

    public static class OrgJetbrainsLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinxLibraryAccessors laccForOrgJetbrainsKotlinxLibraryAccessors = new OrgJetbrainsKotlinxLibraryAccessors(owner);

        public OrgJetbrainsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for annotations (org.jetbrains:annotations)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAnnotations() { return create("org.jetbrains.annotations"); }

        /**
         * Returns the group of libraries at org.jetbrains.kotlinx
         */
        public OrgJetbrainsKotlinxLibraryAccessors getKotlinx() { return laccForOrgJetbrainsKotlinxLibraryAccessors; }

    }

    public static class OrgJetbrainsKotlinxLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinxKotlinxLibraryAccessors laccForOrgJetbrainsKotlinxKotlinxLibraryAccessors = new OrgJetbrainsKotlinxKotlinxLibraryAccessors(owner);

        public OrgJetbrainsKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.jetbrains.kotlinx.kotlinx
         */
        public OrgJetbrainsKotlinxKotlinxLibraryAccessors getKotlinx() { return laccForOrgJetbrainsKotlinxKotlinxLibraryAccessors; }

    }

    public static class OrgJetbrainsKotlinxKotlinxLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors laccForOrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors = new OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors(owner);

        public OrgJetbrainsKotlinxKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.jetbrains.kotlinx.kotlinx.coroutines
         */
        public OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors getCoroutines() { return laccForOrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors; }

    }

    public static class OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (org.jetbrains.kotlinx:kotlinx-coroutines-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("org.jetbrains.kotlinx.kotlinx.coroutines.android"); }

            /**
             * Creates a dependency provider for core (org.jetbrains.kotlinx:kotlinx-coroutines-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("org.jetbrains.kotlinx.kotlinx.coroutines.core"); }

            /**
             * Creates a dependency provider for test (org.jetbrains.kotlinx:kotlinx-coroutines-test)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("org.jetbrains.kotlinx.kotlinx.coroutines.test"); }

    }

    public static class OrgJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitJupiterLibraryAccessors laccForOrgJunitJupiterLibraryAccessors = new OrgJunitJupiterLibraryAccessors(owner);

        public OrgJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.junit.jupiter
         */
        public OrgJunitJupiterLibraryAccessors getJupiter() { return laccForOrgJunitJupiterLibraryAccessors; }

    }

    public static class OrgJunitJupiterLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitJupiterJunitLibraryAccessors laccForOrgJunitJupiterJunitLibraryAccessors = new OrgJunitJupiterJunitLibraryAccessors(owner);

        public OrgJunitJupiterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.junit.jupiter.junit
         */
        public OrgJunitJupiterJunitLibraryAccessors getJunit() { return laccForOrgJunitJupiterJunitLibraryAccessors; }

    }

    public static class OrgJunitJupiterJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitJupiterJunitJupiterLibraryAccessors laccForOrgJunitJupiterJunitJupiterLibraryAccessors = new OrgJunitJupiterJunitJupiterLibraryAccessors(owner);

        public OrgJunitJupiterJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.junit.jupiter.junit.jupiter
         */
        public OrgJunitJupiterJunitJupiterLibraryAccessors getJupiter() { return laccForOrgJunitJupiterJunitJupiterLibraryAccessors; }

    }

    public static class OrgJunitJupiterJunitJupiterLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OrgJunitJupiterJunitJupiterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jupiter (org.junit.jupiter:junit-jupiter)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("org.junit.jupiter.junit.jupiter"); }

            /**
             * Creates a dependency provider for api (org.junit.jupiter:junit-jupiter-api)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("org.junit.jupiter.junit.jupiter.api"); }

            /**
             * Creates a dependency provider for engine (org.junit.jupiter:junit-jupiter-engine)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getEngine() { return create("org.junit.jupiter.junit.jupiter.engine"); }

            /**
             * Creates a dependency provider for params (org.junit.jupiter:junit-jupiter-params)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getParams() { return create("org.junit.jupiter.junit.jupiter.params"); }

    }

    public static class UiLibraryAccessors extends SubDependencyFactory {
        private final UiTestLibraryAccessors laccForUiTestLibraryAccessors = new UiTestLibraryAccessors(owner);

        public UiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at ui.test
         */
        public UiTestLibraryAccessors getTest() { return laccForUiTestLibraryAccessors; }

    }

    public static class UiTestLibraryAccessors extends SubDependencyFactory {

        public UiTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit4 (androidx.compose.ui:ui-test-junit4)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit4() { return create("ui.test.junit4"); }

            /**
             * Creates a dependency provider for manifest (androidx.compose.ui:ui-test-manifest)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getManifest() { return create("ui.test.manifest"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final ComposeVersionAccessors vaccForComposeVersionAccessors = new ComposeVersionAccessors(providers, config);
        private final ConstraintlayoutVersionAccessors vaccForConstraintlayoutVersionAccessors = new ConstraintlayoutVersionAccessors(providers, config);
        private final DeVersionAccessors vaccForDeVersionAccessors = new DeVersionAccessors(providers, config);
        private final DesugarVersionAccessors vaccForDesugarVersionAccessors = new DesugarVersionAccessors(providers, config);
        private final DetektVersionAccessors vaccForDetektVersionAccessors = new DetektVersionAccessors(providers, config);
        private final HiltVersionAccessors vaccForHiltVersionAccessors = new HiltVersionAccessors(providers, config);
        private final IoVersionAccessors vaccForIoVersionAccessors = new IoVersionAccessors(providers, config);
        private final KotlinxVersionAccessors vaccForKotlinxVersionAccessors = new KotlinxVersionAccessors(providers, config);
        private final LifecycleVersionAccessors vaccForLifecycleVersionAccessors = new LifecycleVersionAccessors(providers, config);
        private final MaterialVersionAccessors vaccForMaterialVersionAccessors = new MaterialVersionAccessors(providers, config);
        private final MoshiVersionAccessors vaccForMoshiVersionAccessors = new MoshiVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        private final PluginVersionAccessors vaccForPluginVersionAccessors = new PluginVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: appcompat (1.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAppcompat() { return getVersion("appcompat"); }

            /**
             * Returns the version associated to this alias: junit (4.13.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("junit"); }

        /**
         * Returns the group of versions at versions.androidx
         */
        public AndroidxVersionAccessors getAndroidx() { return vaccForAndroidxVersionAccessors; }

        /**
         * Returns the group of versions at versions.com
         */
        public ComVersionAccessors getCom() { return vaccForComVersionAccessors; }

        /**
         * Returns the group of versions at versions.compose
         */
        public ComposeVersionAccessors getCompose() { return vaccForComposeVersionAccessors; }

        /**
         * Returns the group of versions at versions.constraintlayout
         */
        public ConstraintlayoutVersionAccessors getConstraintlayout() { return vaccForConstraintlayoutVersionAccessors; }

        /**
         * Returns the group of versions at versions.de
         */
        public DeVersionAccessors getDe() { return vaccForDeVersionAccessors; }

        /**
         * Returns the group of versions at versions.desugar
         */
        public DesugarVersionAccessors getDesugar() { return vaccForDesugarVersionAccessors; }

        /**
         * Returns the group of versions at versions.detekt
         */
        public DetektVersionAccessors getDetekt() { return vaccForDetektVersionAccessors; }

        /**
         * Returns the group of versions at versions.hilt
         */
        public HiltVersionAccessors getHilt() { return vaccForHiltVersionAccessors; }

        /**
         * Returns the group of versions at versions.io
         */
        public IoVersionAccessors getIo() { return vaccForIoVersionAccessors; }

        /**
         * Returns the group of versions at versions.kotlinx
         */
        public KotlinxVersionAccessors getKotlinx() { return vaccForKotlinxVersionAccessors; }

        /**
         * Returns the group of versions at versions.lifecycle
         */
        public LifecycleVersionAccessors getLifecycle() { return vaccForLifecycleVersionAccessors; }

        /**
         * Returns the group of versions at versions.material
         */
        public MaterialVersionAccessors getMaterial() { return vaccForMaterialVersionAccessors; }

        /**
         * Returns the group of versions at versions.moshi
         */
        public MoshiVersionAccessors getMoshi() { return vaccForMoshiVersionAccessors; }

        /**
         * Returns the group of versions at versions.org
         */
        public OrgVersionAccessors getOrg() { return vaccForOrgVersionAccessors; }

        /**
         * Returns the group of versions at versions.plugin
         */
        public PluginVersionAccessors getPlugin() { return vaccForPluginVersionAccessors; }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        private final AndroidxArchVersionAccessors vaccForAndroidxArchVersionAccessors = new AndroidxArchVersionAccessors(providers, config);
        private final AndroidxComposeVersionAccessors vaccForAndroidxComposeVersionAccessors = new AndroidxComposeVersionAccessors(providers, config);
        private final AndroidxCoreVersionAccessors vaccForAndroidxCoreVersionAccessors = new AndroidxCoreVersionAccessors(providers, config);
        private final AndroidxLifecycleVersionAccessors vaccForAndroidxLifecycleVersionAccessors = new AndroidxLifecycleVersionAccessors(providers, config);
        private final AndroidxTestVersionAccessors vaccForAndroidxTestVersionAccessors = new AndroidxTestVersionAccessors(providers, config);
        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.activity (1.8.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getActivity() { return getVersion("androidx.activity"); }

            /**
             * Returns the version associated to this alias: androidx.biometric (1.2.0-alpha05)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBiometric() { return getVersion("androidx.biometric"); }

            /**
             * Returns the version associated to this alias: androidx.datastore (1.1.0-alpha06)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDatastore() { return getVersion("androidx.datastore"); }

            /**
             * Returns the version associated to this alias: androidx.emoji2 (1.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEmoji2() { return getVersion("androidx.emoji2"); }

            /**
             * Returns the version associated to this alias: androidx.multidex (2.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMultidex() { return getVersion("androidx.multidex"); }

            /**
             * Returns the version associated to this alias: androidx.navigation (2.7.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNavigation() { return getVersion("androidx.navigation"); }

            /**
             * Returns the version associated to this alias: androidx.paging (3.3.0-alpha02)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPaging() { return getVersion("androidx.paging"); }

            /**
             * Returns the version associated to this alias: androidx.room (2.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRoom() { return getVersion("androidx.room"); }

        /**
         * Returns the group of versions at versions.androidx.arch
         */
        public AndroidxArchVersionAccessors getArch() { return vaccForAndroidxArchVersionAccessors; }

        /**
         * Returns the group of versions at versions.androidx.compose
         */
        public AndroidxComposeVersionAccessors getCompose() { return vaccForAndroidxComposeVersionAccessors; }

        /**
         * Returns the group of versions at versions.androidx.core
         */
        public AndroidxCoreVersionAccessors getCore() { return vaccForAndroidxCoreVersionAccessors; }

        /**
         * Returns the group of versions at versions.androidx.lifecycle
         */
        public AndroidxLifecycleVersionAccessors getLifecycle() { return vaccForAndroidxLifecycleVersionAccessors; }

        /**
         * Returns the group of versions at versions.androidx.test
         */
        public AndroidxTestVersionAccessors getTest() { return vaccForAndroidxTestVersionAccessors; }

    }

    public static class AndroidxArchVersionAccessors extends VersionFactory  {

        public AndroidxArchVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.arch.core (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("androidx.arch.core"); }

            /**
             * Returns the version associated to this alias: androidx.arch.testing (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTesting() { return getVersion("androidx.arch.testing"); }

    }

    public static class AndroidxComposeVersionAccessors extends VersionFactory  {

        public AndroidxComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.compose.compiler (1.5.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompiler() { return getVersion("androidx.compose.compiler"); }

    }

    public static class AndroidxCoreVersionAccessors extends VersionFactory  {

        public AndroidxCoreVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.core.ktx (1.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtx() { return getVersion("androidx.core.ktx"); }

            /**
             * Returns the version associated to this alias: androidx.core.splashscreen (1.1.0-alpha02)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSplashscreen() { return getVersion("androidx.core.splashscreen"); }

    }

    public static class AndroidxLifecycleVersionAccessors extends VersionFactory  {

        public AndroidxLifecycleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.lifecycle.extensions (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getExtensions() { return getVersion("androidx.lifecycle.extensions"); }

            /**
             * Returns the version associated to this alias: androidx.lifecycle.service (2.7.0-beta01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getService() { return getVersion("androidx.lifecycle.service"); }

            /**
             * Returns the version associated to this alias: androidx.lifecycle.viewmodel (2.7.0-beta01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getViewmodel() { return getVersion("androidx.lifecycle.viewmodel"); }

    }

    public static class AndroidxTestVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final AndroidxTestExtVersionAccessors vaccForAndroidxTestExtVersionAccessors = new AndroidxTestExtVersionAccessors(providers, config);
        public AndroidxTestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: androidx.test (1.6.0-alpha04)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("androidx.test"); }

            /**
             * Returns the version associated to this alias: androidx.test.core (1.6.0-alpha02)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("androidx.test.core"); }

            /**
             * Returns the version associated to this alias: androidx.test.espresso (3.6.0-alpha01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEspresso() { return getVersion("androidx.test.espresso"); }

        /**
         * Returns the group of versions at versions.androidx.test.ext
         */
        public AndroidxTestExtVersionAccessors getExt() { return vaccForAndroidxTestExtVersionAccessors; }

    }

    public static class AndroidxTestExtVersionAccessors extends VersionFactory  {

        public AndroidxTestExtVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.test.ext.junit (1.2.0-alpha01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("androidx.test.ext.junit"); }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComAgodaVersionAccessors vaccForComAgodaVersionAccessors = new ComAgodaVersionAccessors(providers, config);
        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        private final ComJakewhartonVersionAccessors vaccForComJakewhartonVersionAccessors = new ComJakewhartonVersionAccessors(providers, config);
        private final ComSquareupVersionAccessors vaccForComSquareupVersionAccessors = new ComSquareupVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.agoda
         */
        public ComAgodaVersionAccessors getAgoda() { return vaccForComAgodaVersionAccessors; }

        /**
         * Returns the group of versions at versions.com.google
         */
        public ComGoogleVersionAccessors getGoogle() { return vaccForComGoogleVersionAccessors; }

        /**
         * Returns the group of versions at versions.com.jakewharton
         */
        public ComJakewhartonVersionAccessors getJakewharton() { return vaccForComJakewhartonVersionAccessors; }

        /**
         * Returns the group of versions at versions.com.squareup
         */
        public ComSquareupVersionAccessors getSquareup() { return vaccForComSquareupVersionAccessors; }

    }

    public static class ComAgodaVersionAccessors extends VersionFactory  {

        public ComAgodaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.agoda.kakao (2.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKakao() { return getVersion("com.agoda.kakao"); }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleCodeVersionAccessors vaccForComGoogleCodeVersionAccessors = new ComGoogleCodeVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.google.accompanist (0.33.2-alpha)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAccompanist() { return getVersion("com.google.accompanist"); }

            /**
             * Returns the version associated to this alias: com.google.dagger (2.48.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDagger() { return getVersion("com.google.dagger"); }

        /**
         * Returns the group of versions at versions.com.google.code
         */
        public ComGoogleCodeVersionAccessors getCode() { return vaccForComGoogleCodeVersionAccessors; }

    }

    public static class ComGoogleCodeVersionAccessors extends VersionFactory  {

        public ComGoogleCodeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.google.code.gson (2.10.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGson() { return getVersion("com.google.code.gson"); }

    }

    public static class ComJakewhartonVersionAccessors extends VersionFactory  {

        public ComJakewhartonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.jakewharton.timber (5.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTimber() { return getVersion("com.jakewharton.timber"); }

    }

    public static class ComSquareupVersionAccessors extends VersionFactory  {

        public ComSquareupVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.squareup.okhttp3 (5.0.0-alpha.11)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOkhttp3() { return getVersion("com.squareup.okhttp3"); }

            /**
             * Returns the version associated to this alias: com.squareup.retrofit2 (2.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRetrofit2() { return getVersion("com.squareup.retrofit2"); }

    }

    public static class ComposeVersionAccessors extends VersionFactory  {

        public ComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: compose.bom (2023.10.01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBom() { return getVersion("compose.bom"); }

    }

    public static class ConstraintlayoutVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public ConstraintlayoutVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: constraintlayout (2.1.4)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("constraintlayout"); }

            /**
             * Returns the version associated to this alias: constraintlayout.compose (1.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompose() { return getVersion("constraintlayout.compose"); }

    }

    public static class DeVersionAccessors extends VersionFactory  {

        private final DeMannodermausVersionAccessors vaccForDeMannodermausVersionAccessors = new DeMannodermausVersionAccessors(providers, config);
        public DeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.de.mannodermaus
         */
        public DeMannodermausVersionAccessors getMannodermaus() { return vaccForDeMannodermausVersionAccessors; }

    }

    public static class DeMannodermausVersionAccessors extends VersionFactory  {

        public DeMannodermausVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: de.mannodermaus.junit5 (1.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit5() { return getVersion("de.mannodermaus.junit5"); }

    }

    public static class DesugarVersionAccessors extends VersionFactory  {

        private final DesugarJdkVersionAccessors vaccForDesugarJdkVersionAccessors = new DesugarJdkVersionAccessors(providers, config);
        public DesugarVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.desugar.jdk
         */
        public DesugarJdkVersionAccessors getJdk() { return vaccForDesugarJdkVersionAccessors; }

    }

    public static class DesugarJdkVersionAccessors extends VersionFactory  {

        public DesugarJdkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: desugar.jdk.libs (2.0.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLibs() { return getVersion("desugar.jdk.libs"); }

    }

    public static class DetektVersionAccessors extends VersionFactory  {

        public DetektVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: detekt.version (1.23.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersion() { return getVersion("detekt.version"); }

    }

    public static class HiltVersionAccessors extends VersionFactory  {

        public HiltVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: hilt.compose (1.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompose() { return getVersion("hilt.compose"); }

    }

    public static class IoVersionAccessors extends VersionFactory  {

        private final IoCoilVersionAccessors vaccForIoCoilVersionAccessors = new IoCoilVersionAccessors(providers, config);
        public IoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: io.mockk (1.13.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMockk() { return getVersion("io.mockk"); }

        /**
         * Returns the group of versions at versions.io.coil
         */
        public IoCoilVersionAccessors getCoil() { return vaccForIoCoilVersionAccessors; }

    }

    public static class IoCoilVersionAccessors extends VersionFactory  {

        public IoCoilVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: io.coil.kt (2.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKt() { return getVersion("io.coil.kt"); }

    }

    public static class KotlinxVersionAccessors extends VersionFactory  {

        private final KotlinxCoroutinesVersionAccessors vaccForKotlinxCoroutinesVersionAccessors = new KotlinxCoroutinesVersionAccessors(providers, config);
        public KotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.kotlinx.coroutines
         */
        public KotlinxCoroutinesVersionAccessors getCoroutines() { return vaccForKotlinxCoroutinesVersionAccessors; }

    }

    public static class KotlinxCoroutinesVersionAccessors extends VersionFactory  {

        public KotlinxCoroutinesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: kotlinx.coroutines.test (1.7.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTest() { return getVersion("kotlinx.coroutines.test"); }

    }

    public static class LifecycleVersionAccessors extends VersionFactory  {

        private final LifecycleRuntimeVersionAccessors vaccForLifecycleRuntimeVersionAccessors = new LifecycleRuntimeVersionAccessors(providers, config);
        public LifecycleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.lifecycle.runtime
         */
        public LifecycleRuntimeVersionAccessors getRuntime() { return vaccForLifecycleRuntimeVersionAccessors; }

    }

    public static class LifecycleRuntimeVersionAccessors extends VersionFactory  {

        public LifecycleRuntimeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: lifecycle.runtime.ktx (2.6.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtx() { return getVersion("lifecycle.runtime.ktx"); }

    }

    public static class MaterialVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final MaterialIconsVersionAccessors vaccForMaterialIconsVersionAccessors = new MaterialIconsVersionAccessors(providers, config);
        public MaterialVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: material (1.10.0)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("material"); }

        /**
         * Returns the group of versions at versions.material.icons
         */
        public MaterialIconsVersionAccessors getIcons() { return vaccForMaterialIconsVersionAccessors; }

    }

    public static class MaterialIconsVersionAccessors extends VersionFactory  {

        public MaterialIconsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: material.icons.extended (1.6.0-alpha08)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getExtended() { return getVersion("material.icons.extended"); }

    }

    public static class MoshiVersionAccessors extends VersionFactory  {

        public MoshiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: moshi.version (1.15.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersion() { return getVersion("moshi.version"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgAmshoveVersionAccessors vaccForOrgAmshoveVersionAccessors = new OrgAmshoveVersionAccessors(providers, config);
        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgJetbrainsVersionAccessors vaccForOrgJetbrainsVersionAccessors = new OrgJetbrainsVersionAccessors(providers, config);
        private final OrgJunitVersionAccessors vaccForOrgJunitVersionAccessors = new OrgJunitVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.jacoco (0.8.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJacoco() { return getVersion("org.jacoco"); }

            /**
             * Returns the version associated to this alias: org.robolectric (4.10.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRobolectric() { return getVersion("org.robolectric"); }

        /**
         * Returns the group of versions at versions.org.amshove
         */
        public OrgAmshoveVersionAccessors getAmshove() { return vaccForOrgAmshoveVersionAccessors; }

        /**
         * Returns the group of versions at versions.org.apache
         */
        public OrgApacheVersionAccessors getApache() { return vaccForOrgApacheVersionAccessors; }

        /**
         * Returns the group of versions at versions.org.jetbrains
         */
        public OrgJetbrainsVersionAccessors getJetbrains() { return vaccForOrgJetbrainsVersionAccessors; }

        /**
         * Returns the group of versions at versions.org.junit
         */
        public OrgJunitVersionAccessors getJunit() { return vaccForOrgJunitVersionAccessors; }

    }

    public static class OrgAmshoveVersionAccessors extends VersionFactory  {

        private final OrgAmshoveKluentVersionAccessors vaccForOrgAmshoveKluentVersionAccessors = new OrgAmshoveKluentVersionAccessors(providers, config);
        public OrgAmshoveVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.amshove.kluent
         */
        public OrgAmshoveKluentVersionAccessors getKluent() { return vaccForOrgAmshoveKluentVersionAccessors; }

    }

    public static class OrgAmshoveKluentVersionAccessors extends VersionFactory  {

        public OrgAmshoveKluentVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.amshove.kluent.android (1.73)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroid() { return getVersion("org.amshove.kluent.android"); }

    }

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheLoggingVersionAccessors vaccForOrgApacheLoggingVersionAccessors = new OrgApacheLoggingVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache.logging
         */
        public OrgApacheLoggingVersionAccessors getLogging() { return vaccForOrgApacheLoggingVersionAccessors; }

    }

    public static class OrgApacheLoggingVersionAccessors extends VersionFactory  {

        private final OrgApacheLoggingLog4jVersionAccessors vaccForOrgApacheLoggingLog4jVersionAccessors = new OrgApacheLoggingLog4jVersionAccessors(providers, config);
        public OrgApacheLoggingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache.logging.log4j
         */
        public OrgApacheLoggingLog4jVersionAccessors getLog4j() { return vaccForOrgApacheLoggingLog4jVersionAccessors; }

    }

    public static class OrgApacheLoggingLog4jVersionAccessors extends VersionFactory  {

        public OrgApacheLoggingLog4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.apache.logging.log4j.core (3.0.0-alpha1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("org.apache.logging.log4j.core"); }

    }

    public static class OrgJetbrainsVersionAccessors extends VersionFactory  {

        private final OrgJetbrainsKotlinxVersionAccessors vaccForOrgJetbrainsKotlinxVersionAccessors = new OrgJetbrainsKotlinxVersionAccessors(providers, config);
        public OrgJetbrainsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.jetbrains.annotations (23.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAnnotations() { return getVersion("org.jetbrains.annotations"); }

        /**
         * Returns the group of versions at versions.org.jetbrains.kotlinx
         */
        public OrgJetbrainsKotlinxVersionAccessors getKotlinx() { return vaccForOrgJetbrainsKotlinxVersionAccessors; }

    }

    public static class OrgJetbrainsKotlinxVersionAccessors extends VersionFactory  {

        private final OrgJetbrainsKotlinxCoroutinesVersionAccessors vaccForOrgJetbrainsKotlinxCoroutinesVersionAccessors = new OrgJetbrainsKotlinxCoroutinesVersionAccessors(providers, config);
        public OrgJetbrainsKotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.jetbrains.kotlinx.coroutines
         */
        public OrgJetbrainsKotlinxCoroutinesVersionAccessors getCoroutines() { return vaccForOrgJetbrainsKotlinxCoroutinesVersionAccessors; }

    }

    public static class OrgJetbrainsKotlinxCoroutinesVersionAccessors extends VersionFactory  {

        public OrgJetbrainsKotlinxCoroutinesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.jetbrains.kotlinx.coroutines.android (1.7.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroid() { return getVersion("org.jetbrains.kotlinx.coroutines.android"); }

    }

    public static class OrgJunitVersionAccessors extends VersionFactory  {

        public OrgJunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.junit.jupiter (5.10.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJupiter() { return getVersion("org.junit.jupiter"); }

    }

    public static class PluginVersionAccessors extends VersionFactory  {

        private final PluginBenVersionAccessors vaccForPluginBenVersionAccessors = new PluginBenVersionAccessors(providers, config);
        private final PluginGradleVersionAccessors vaccForPluginGradleVersionAccessors = new PluginGradleVersionAccessors(providers, config);
        private final PluginKotlinVersionAccessors vaccForPluginKotlinVersionAccessors = new PluginKotlinVersionAccessors(providers, config);
        private final PluginKspVersionAccessors vaccForPluginKspVersionAccessors = new PluginKspVersionAccessors(providers, config);
        private final PluginLittlerobotsVersionAccessors vaccForPluginLittlerobotsVersionAccessors = new PluginLittlerobotsVersionAccessors(providers, config);
        private final PluginMannodermausVersionAccessors vaccForPluginMannodermausVersionAccessors = new PluginMannodermausVersionAccessors(providers, config);
        public PluginVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.plugin.ben
         */
        public PluginBenVersionAccessors getBen() { return vaccForPluginBenVersionAccessors; }

        /**
         * Returns the group of versions at versions.plugin.gradle
         */
        public PluginGradleVersionAccessors getGradle() { return vaccForPluginGradleVersionAccessors; }

        /**
         * Returns the group of versions at versions.plugin.kotlin
         */
        public PluginKotlinVersionAccessors getKotlin() { return vaccForPluginKotlinVersionAccessors; }

        /**
         * Returns the group of versions at versions.plugin.ksp
         */
        public PluginKspVersionAccessors getKsp() { return vaccForPluginKspVersionAccessors; }

        /**
         * Returns the group of versions at versions.plugin.littlerobots
         */
        public PluginLittlerobotsVersionAccessors getLittlerobots() { return vaccForPluginLittlerobotsVersionAccessors; }

        /**
         * Returns the group of versions at versions.plugin.mannodermaus
         */
        public PluginMannodermausVersionAccessors getMannodermaus() { return vaccForPluginMannodermausVersionAccessors; }

    }

    public static class PluginBenVersionAccessors extends VersionFactory  {

        private final PluginBenManesVersionAccessors vaccForPluginBenManesVersionAccessors = new PluginBenManesVersionAccessors(providers, config);
        public PluginBenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.plugin.ben.manes
         */
        public PluginBenManesVersionAccessors getManes() { return vaccForPluginBenManesVersionAccessors; }

    }

    public static class PluginBenManesVersionAccessors extends VersionFactory  {

        public PluginBenManesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: plugin.ben.manes.version (0.49.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersion() { return getVersion("plugin.ben.manes.version"); }

    }

    public static class PluginGradleVersionAccessors extends VersionFactory  {

        public PluginGradleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: plugin.gradle.version (8.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersion() { return getVersion("plugin.gradle.version"); }

    }

    public static class PluginKotlinVersionAccessors extends VersionFactory  {

        public PluginKotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: plugin.kotlin.version (1.9.20)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersion() { return getVersion("plugin.kotlin.version"); }

    }

    public static class PluginKspVersionAccessors extends VersionFactory  {

        public PluginKspVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: plugin.ksp.version (1.9.20-1.0.13)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersion() { return getVersion("plugin.ksp.version"); }

    }

    public static class PluginLittlerobotsVersionAccessors extends VersionFactory  {

        public PluginLittlerobotsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: plugin.littlerobots.version (0.8.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersion() { return getVersion("plugin.littlerobots.version"); }

    }

    public static class PluginMannodermausVersionAccessors extends VersionFactory  {

        public PluginMannodermausVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: plugin.mannodermaus.version (1.9.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersion() { return getVersion("plugin.mannodermaus.version"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final CompilersBundleAccessors baccForCompilersBundleAccessors = new CompilersBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final LayerBundleAccessors baccForLayerBundleAccessors = new LayerBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final TestingBundleAccessors baccForTestingBundleAccessors = new TestingBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Returns the group of bundles at bundles.compilers
         */
        public CompilersBundleAccessors getCompilers() { return baccForCompilersBundleAccessors; }

        /**
         * Returns the group of bundles at bundles.layer
         */
        public LayerBundleAccessors getLayer() { return baccForLayerBundleAccessors; }

        /**
         * Returns the group of bundles at bundles.testing
         */
        public TestingBundleAccessors getTesting() { return baccForTestingBundleAccessors; }

    }

    public static class CompilersBundleAccessors extends BundleFactory {
        private final CompilersKspBundleAccessors baccForCompilersKspBundleAccessors = new CompilersKspBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public CompilersBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Returns the group of bundles at bundles.compilers.ksp
         */
        public CompilersKspBundleAccessors getKsp() { return baccForCompilersKspBundleAccessors; }

    }

    public static class CompilersKspBundleAccessors extends BundleFactory {

        public CompilersKspBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for compilers.ksp.data which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.google.dagger:hilt-android-compiler</li>
             *    <li>androidx.room:room-compiler</li>
             *    <li>com.squareup.moshi:moshi-kotlin-codegen</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getData() { return createBundle("compilers.ksp.data"); }

            /**
             * Creates a dependency bundle provider for compilers.ksp.generic which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.google.dagger:hilt-android-compiler</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getGeneric() { return createBundle("compilers.ksp.generic"); }

    }

    public static class LayerBundleAccessors extends BundleFactory {
        private final LayerCoreBundleAccessors baccForLayerCoreBundleAccessors = new LayerCoreBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public LayerBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for layer.data which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.core:core-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             *    <li>androidx.multidex:multidex</li>
             *    <li>androidx.paging:paging-runtime-ktx</li>
             *    <li>androidx.room:room-ktx</li>
             *    <li>androidx.room:room-runtime</li>
             *    <li>com.google.code.gson:gson</li>
             *    <li>com.google.dagger:hilt-android</li>
             *    <li>com.jakewharton.timber:timber</li>
             *    <li>com.squareup.retrofit2:retrofit</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-android</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-core</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getData() { return createBundle("layer.data"); }

            /**
             * Creates a dependency bundle provider for layer.datasource which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.core:core-ktx</li>
             *    <li>androidx.datastore:datastore-preferences</li>
             *    <li>androidx.datastore:datastore-preferences-core</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             *    <li>androidx.multidex:multidex</li>
             *    <li>androidx.paging:paging-runtime-ktx</li>
             *    <li>androidx.room:room-ktx</li>
             *    <li>androidx.room:room-runtime</li>
             *    <li>com.google.code.gson:gson</li>
             *    <li>com.google.dagger:hilt-android</li>
             *    <li>com.jakewharton.timber:timber</li>
             *    <li>com.squareup.moshi:moshi-kotlin</li>
             *    <li>com.squareup.moshi:moshi-adapters</li>
             *    <li>com.squareup.okhttp3:logging-interceptor</li>
             *    <li>com.squareup.retrofit2:converter-gson</li>
             *    <li>com.squareup.retrofit2:retrofit</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-android</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-core</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getDatasource() { return createBundle("layer.datasource"); }

            /**
             * Creates a dependency bundle provider for layer.domain which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.core:core-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             *    <li>androidx.multidex:multidex</li>
             *    <li>androidx.paging:paging-runtime-ktx</li>
             *    <li>com.google.code.gson:gson</li>
             *    <li>com.google.dagger:hilt-android</li>
             *    <li>com.jakewharton.timber:timber</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-android</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-core</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getDomain() { return createBundle("layer.domain"); }

            /**
             * Creates a dependency bundle provider for layer.models which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.core:core-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             *    <li>androidx.multidex:multidex</li>
             *    <li>com.google.code.gson:gson</li>
             *    <li>com.google.dagger:hilt-android</li>
             *    <li>com.jakewharton.timber:timber</li>
             *    <li>com.squareup.moshi:moshi-kotlin</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-android</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-core</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getModels() { return createBundle("layer.models"); }

            /**
             * Creates a dependency bundle provider for layer.ui which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.activity:activity-compose</li>
             *    <li>androidx.activity:activity-ktx</li>
             *    <li>androidx.biometric:biometric-ktx</li>
             *    <li>androidx.compose.animation:animation</li>
             *    <li>androidx.compose.animation:animation-core</li>
             *    <li>androidx.compose.animation:animation-graphics</li>
             *    <li>androidx.compose.material:material-icons-extended</li>
             *    <li>androidx.compose.material3:material3</li>
             *    <li>androidx.compose.ui:ui</li>
             *    <li>androidx.compose.ui:ui-graphics</li>
             *    <li>androidx.compose.ui:ui-tooling</li>
             *    <li>androidx.compose.ui:ui-tooling-preview</li>
             *    <li>androidx.constraintlayout:constraintlayout-compose</li>
             *    <li>androidx.core:core-ktx</li>
             *    <li>androidx.core:core-splashscreen</li>
             *    <li>androidx.emoji2:emoji2</li>
             *    <li>androidx.emoji2:emoji2-views</li>
             *    <li>androidx.emoji2:emoji2-views-helper</li>
             *    <li>androidx.lifecycle:lifecycle-extensions</li>
             *    <li>androidx.lifecycle:lifecycle-service</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-runtime-compose</li>
             *    <li>androidx.multidex:multidex</li>
             *    <li>androidx.navigation:navigation-compose</li>
             *    <li>androidx.paging:paging-runtime-ktx</li>
             *    <li>androidx.paging:paging-compose</li>
             *    <li>com.google.accompanist:accompanist-navigation-animation</li>
             *    <li>com.google.accompanist:accompanist-pager</li>
             *    <li>com.google.accompanist:accompanist-pager-indicators</li>
             *    <li>com.google.accompanist:accompanist-permissions</li>
             *    <li>com.google.accompanist:accompanist-swiperefresh</li>
             *    <li>com.google.code.gson:gson</li>
             *    <li>com.google.dagger:hilt-android</li>
             *    <li>androidx.hilt:hilt-navigation-compose</li>
             *    <li>com.jakewharton.timber:timber</li>
             *    <li>io.coil-kt:coil-compose</li>
             *    <li>io.coil-kt:coil-gif</li>
             *    <li>io.coil-kt:coil-svg</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-android</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-core</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getUi() { return createBundle("layer.ui"); }

            /**
             * Creates a dependency bundle provider for layer.viewmodels which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.core:core-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-extensions</li>
             *    <li>androidx.lifecycle:lifecycle-service</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             *    <li>androidx.multidex:multidex</li>
             *    <li>androidx.paging:paging-runtime-ktx</li>
             *    <li>com.google.code.gson:gson</li>
             *    <li>com.google.dagger:hilt-android</li>
             *    <li>com.jakewharton.timber:timber</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-android</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-core</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getViewmodels() { return createBundle("layer.viewmodels"); }

        /**
         * Returns the group of bundles at bundles.layer.core
         */
        public LayerCoreBundleAccessors getCore() { return baccForLayerCoreBundleAccessors; }

    }

    public static class LayerCoreBundleAccessors extends BundleFactory {

        public LayerCoreBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for layer.core.common which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.core:core-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             *    <li>androidx.multidex:multidex</li>
             *    <li>com.google.code.gson:gson</li>
             *    <li>com.google.dagger:hilt-android</li>
             *    <li>com.jakewharton.timber:timber</li>
             *    <li>com.squareup.moshi:moshi-kotlin</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-android</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-core</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getCommon() { return createBundle("layer.core.common"); }

    }

    public static class TestingBundleAccessors extends BundleFactory {
        private final TestingAndroidBundleAccessors baccForTestingAndroidBundleAccessors = new TestingAndroidBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final TestingUnitBundleAccessors baccForTestingUnitBundleAccessors = new TestingUnitBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public TestingBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Returns the group of bundles at bundles.testing.android
         */
        public TestingAndroidBundleAccessors getAndroid() { return baccForTestingAndroidBundleAccessors; }

        /**
         * Returns the group of bundles at bundles.testing.unit
         */
        public TestingUnitBundleAccessors getUnit() { return baccForTestingUnitBundleAccessors; }

    }

    public static class TestingAndroidBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public TestingAndroidBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for testing.android which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.arch.core:core-testing</li>
             *    <li>androidx.test.espresso:espresso-core</li>
             *    <li>androidx.test.ext:junit</li>
             *    <li>androidx.test:runner</li>
             *    <li>de.mannodermaus.junit5:android-test-core</li>
             *    <li>io.mockk:mockk</li>
             *    <li>org.amshove.kluent:kluent-android</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-test</li>
             *    <li>org.junit.jupiter:junit-jupiter</li>
             *    <li>org.junit.jupiter:junit-jupiter-api</li>
             *    <li>org.robolectric:robolectric</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> asProvider() { return createBundle("testing.android"); }

            /**
             * Creates a dependency bundle provider for testing.android.runtime which is an aggregate for the following dependencies:
             * <ul>
             *    <li>de.mannodermaus.junit5:android-test-runner</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getRuntime() { return createBundle("testing.android.runtime"); }

    }

    public static class TestingUnitBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public TestingUnitBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for testing.unit which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.arch.core:core-common</li>
             *    <li>androidx.arch.core:core-runtime</li>
             *    <li>androidx.arch.core:core-testing</li>
             *    <li>androidx.test:core-ktx</li>
             *    <li>androidx.test.espresso:espresso-contrib</li>
             *    <li>androidx.test.espresso:espresso-core</li>
             *    <li>com.agoda.kakao:kakao</li>
             *    <li>io.mockk:mockk</li>
             *    <li>org.amshove.kluent:kluent-android</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-test</li>
             *    <li>org.junit.jupiter:junit-jupiter</li>
             *    <li>org.junit.jupiter:junit-jupiter-api</li>
             *    <li>org.junit.jupiter:junit-jupiter-params</li>
             *    <li>org.robolectric:robolectric</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> asProvider() { return createBundle("testing.unit"); }

            /**
             * Creates a dependency bundle provider for testing.unit.runtime which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.junit.jupiter:junit-jupiter-engine</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getRuntime() { return createBundle("testing.unit.runtime"); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final ComPluginAccessors paccForComPluginAccessors = new ComPluginAccessors(providers, config);
        private final DePluginAccessors paccForDePluginAccessors = new DePluginAccessors(providers, config);
        private final IoPluginAccessors paccForIoPluginAccessors = new IoPluginAccessors(providers, config);
        private final NlPluginAccessors paccForNlPluginAccessors = new NlPluginAccessors(providers, config);
        private final OrgPluginAccessors paccForOrgPluginAccessors = new OrgPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com
         */
        public ComPluginAccessors getCom() { return paccForComPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.de
         */
        public DePluginAccessors getDe() { return paccForDePluginAccessors; }

        /**
         * Returns the group of plugins at plugins.io
         */
        public IoPluginAccessors getIo() { return paccForIoPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.nl
         */
        public NlPluginAccessors getNl() { return paccForNlPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.org
         */
        public OrgPluginAccessors getOrg() { return paccForOrgPluginAccessors; }

    }

    public static class ComPluginAccessors extends PluginFactory {
        private final ComAndroidPluginAccessors paccForComAndroidPluginAccessors = new ComAndroidPluginAccessors(providers, config);
        private final ComGithubPluginAccessors paccForComGithubPluginAccessors = new ComGithubPluginAccessors(providers, config);
        private final ComGooglePluginAccessors paccForComGooglePluginAccessors = new ComGooglePluginAccessors(providers, config);

        public ComPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.android
         */
        public ComAndroidPluginAccessors getAndroid() { return paccForComAndroidPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.com.github
         */
        public ComGithubPluginAccessors getGithub() { return paccForComGithubPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.com.google
         */
        public ComGooglePluginAccessors getGoogle() { return paccForComGooglePluginAccessors; }

    }

    public static class ComAndroidPluginAccessors extends PluginFactory {

        public ComAndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.android.application to the plugin id 'com.android.application'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getApplication() { return createPlugin("com.android.application"); }

            /**
             * Creates a plugin provider for com.android.library to the plugin id 'com.android.library'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getLibrary() { return createPlugin("com.android.library"); }

    }

    public static class ComGithubPluginAccessors extends PluginFactory {
        private final ComGithubBenPluginAccessors paccForComGithubBenPluginAccessors = new ComGithubBenPluginAccessors(providers, config);

        public ComGithubPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.github.ben
         */
        public ComGithubBenPluginAccessors getBen() { return paccForComGithubBenPluginAccessors; }

    }

    public static class ComGithubBenPluginAccessors extends PluginFactory {
        private final ComGithubBenManesPluginAccessors paccForComGithubBenManesPluginAccessors = new ComGithubBenManesPluginAccessors(providers, config);

        public ComGithubBenPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.github.ben.manes
         */
        public ComGithubBenManesPluginAccessors getManes() { return paccForComGithubBenManesPluginAccessors; }

    }

    public static class ComGithubBenManesPluginAccessors extends PluginFactory {

        public ComGithubBenManesPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.github.ben.manes.versions to the plugin id 'com.github.ben-manes.versions'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getVersions() { return createPlugin("com.github.ben.manes.versions"); }

    }

    public static class ComGooglePluginAccessors extends PluginFactory {
        private final ComGoogleDaggerPluginAccessors paccForComGoogleDaggerPluginAccessors = new ComGoogleDaggerPluginAccessors(providers, config);
        private final ComGoogleDevtoolsPluginAccessors paccForComGoogleDevtoolsPluginAccessors = new ComGoogleDevtoolsPluginAccessors(providers, config);

        public ComGooglePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.google.dagger
         */
        public ComGoogleDaggerPluginAccessors getDagger() { return paccForComGoogleDaggerPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.com.google.devtools
         */
        public ComGoogleDevtoolsPluginAccessors getDevtools() { return paccForComGoogleDevtoolsPluginAccessors; }

    }

    public static class ComGoogleDaggerPluginAccessors extends PluginFactory {
        private final ComGoogleDaggerHiltPluginAccessors paccForComGoogleDaggerHiltPluginAccessors = new ComGoogleDaggerHiltPluginAccessors(providers, config);

        public ComGoogleDaggerPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.google.dagger.hilt
         */
        public ComGoogleDaggerHiltPluginAccessors getHilt() { return paccForComGoogleDaggerHiltPluginAccessors; }

    }

    public static class ComGoogleDaggerHiltPluginAccessors extends PluginFactory {

        public ComGoogleDaggerHiltPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.google.dagger.hilt.android to the plugin id 'com.google.dagger.hilt.android'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("com.google.dagger.hilt.android"); }

    }

    public static class ComGoogleDevtoolsPluginAccessors extends PluginFactory {

        public ComGoogleDevtoolsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.google.devtools.ksp to the plugin id 'com.google.devtools.ksp'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKsp() { return createPlugin("com.google.devtools.ksp"); }

    }

    public static class DePluginAccessors extends PluginFactory {
        private final DeMannodermausPluginAccessors paccForDeMannodermausPluginAccessors = new DeMannodermausPluginAccessors(providers, config);

        public DePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.de.mannodermaus
         */
        public DeMannodermausPluginAccessors getMannodermaus() { return paccForDeMannodermausPluginAccessors; }

    }

    public static class DeMannodermausPluginAccessors extends PluginFactory {
        private final DeMannodermausAndroidPluginAccessors paccForDeMannodermausAndroidPluginAccessors = new DeMannodermausAndroidPluginAccessors(providers, config);

        public DeMannodermausPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.de.mannodermaus.android
         */
        public DeMannodermausAndroidPluginAccessors getAndroid() { return paccForDeMannodermausAndroidPluginAccessors; }

    }

    public static class DeMannodermausAndroidPluginAccessors extends PluginFactory {

        public DeMannodermausAndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for de.mannodermaus.android.junit5 to the plugin id 'de.mannodermaus.android-junit5'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getJunit5() { return createPlugin("de.mannodermaus.android.junit5"); }

    }

    public static class IoPluginAccessors extends PluginFactory {
        private final IoGitlabPluginAccessors paccForIoGitlabPluginAccessors = new IoGitlabPluginAccessors(providers, config);

        public IoPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.io.gitlab
         */
        public IoGitlabPluginAccessors getGitlab() { return paccForIoGitlabPluginAccessors; }

    }

    public static class IoGitlabPluginAccessors extends PluginFactory {
        private final IoGitlabArturboschPluginAccessors paccForIoGitlabArturboschPluginAccessors = new IoGitlabArturboschPluginAccessors(providers, config);

        public IoGitlabPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.io.gitlab.arturbosch
         */
        public IoGitlabArturboschPluginAccessors getArturbosch() { return paccForIoGitlabArturboschPluginAccessors; }

    }

    public static class IoGitlabArturboschPluginAccessors extends PluginFactory {

        public IoGitlabArturboschPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for io.gitlab.arturbosch.detekt to the plugin id 'io.gitlab.arturbosch.detekt'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getDetekt() { return createPlugin("io.gitlab.arturbosch.detekt"); }

    }

    public static class NlPluginAccessors extends PluginFactory {
        private final NlLittlerobotsPluginAccessors paccForNlLittlerobotsPluginAccessors = new NlLittlerobotsPluginAccessors(providers, config);

        public NlPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.nl.littlerobots
         */
        public NlLittlerobotsPluginAccessors getLittlerobots() { return paccForNlLittlerobotsPluginAccessors; }

    }

    public static class NlLittlerobotsPluginAccessors extends PluginFactory {
        private final NlLittlerobotsVersionPluginAccessors paccForNlLittlerobotsVersionPluginAccessors = new NlLittlerobotsVersionPluginAccessors(providers, config);

        public NlLittlerobotsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.nl.littlerobots.version
         */
        public NlLittlerobotsVersionPluginAccessors getVersion() { return paccForNlLittlerobotsVersionPluginAccessors; }

    }

    public static class NlLittlerobotsVersionPluginAccessors extends PluginFactory {
        private final NlLittlerobotsVersionCatalogPluginAccessors paccForNlLittlerobotsVersionCatalogPluginAccessors = new NlLittlerobotsVersionCatalogPluginAccessors(providers, config);

        public NlLittlerobotsVersionPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.nl.littlerobots.version.catalog
         */
        public NlLittlerobotsVersionCatalogPluginAccessors getCatalog() { return paccForNlLittlerobotsVersionCatalogPluginAccessors; }

    }

    public static class NlLittlerobotsVersionCatalogPluginAccessors extends PluginFactory {

        public NlLittlerobotsVersionCatalogPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for nl.littlerobots.version.catalog.update to the plugin id 'nl.littlerobots.version-catalog-update'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getUpdate() { return createPlugin("nl.littlerobots.version.catalog.update"); }

    }

    public static class OrgPluginAccessors extends PluginFactory {
        private final OrgJetbrainsPluginAccessors paccForOrgJetbrainsPluginAccessors = new OrgJetbrainsPluginAccessors(providers, config);

        public OrgPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.jetbrains
         */
        public OrgJetbrainsPluginAccessors getJetbrains() { return paccForOrgJetbrainsPluginAccessors; }

    }

    public static class OrgJetbrainsPluginAccessors extends PluginFactory {
        private final OrgJetbrainsKotlinPluginAccessors paccForOrgJetbrainsKotlinPluginAccessors = new OrgJetbrainsKotlinPluginAccessors(providers, config);

        public OrgJetbrainsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.jetbrains.kotlin
         */
        public OrgJetbrainsKotlinPluginAccessors getKotlin() { return paccForOrgJetbrainsKotlinPluginAccessors; }

    }

    public static class OrgJetbrainsKotlinPluginAccessors extends PluginFactory {

        public OrgJetbrainsKotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for org.jetbrains.kotlin.android to the plugin id 'org.jetbrains.kotlin.android'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("org.jetbrains.kotlin.android"); }

            /**
             * Creates a plugin provider for org.jetbrains.kotlin.jvm to the plugin id 'org.jetbrains.kotlin.jvm'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getJvm() { return createPlugin("org.jetbrains.kotlin.jvm"); }

    }

}
