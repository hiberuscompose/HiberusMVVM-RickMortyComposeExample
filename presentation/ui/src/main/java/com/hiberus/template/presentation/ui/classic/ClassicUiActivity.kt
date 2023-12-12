package com.hiberus.template.presentation.ui.classic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.hiberus.template.presentation.databinding.ActivityClassicUiBinding
import com.hiberus.template.presentation.ui.classic.adapters.CharacterAdapter
import com.hiberus.template.presentation.viewmodels.features.characters.RickAndMortyCharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ClassicUiActivity : AppCompatActivity() {
    private var binding: ActivityClassicUiBinding? = null
    private val viewModel: RickAndMortyCharactersViewModel by viewModels()
    private val pagingAdapter by lazy { CharacterAdapter(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassicUiBinding.inflate(this.layoutInflater)
        setContentView(binding!!.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        binding?.let { bindUi ->
            bindUi.RvCharactersList.layoutManager = LinearLayoutManager(this)
            bindUi.RvCharactersList.adapter = pagingAdapter
        }

        lifecycleScope.launch {
            viewModel.paginatedCharacters.collectLatest { source ->
                pagingAdapter.submitData(source)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}