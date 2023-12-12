package com.hiberus.template.presentation.ui.classic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.hiberus.template.domain.models.characters.RickAndMortyCharacter
import com.hiberus.template.presentation.R
import com.hiberus.template.presentation.databinding.ItemCharacterBinding

class CharacterAdapter(
    private val context: Context
): PagingDataAdapter<RickAndMortyCharacter, CharacterAdapter.CharacterHolder>(RickAndMortyCharacterDiff()) {
    inner class CharacterHolder(val binding: ItemCharacterBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder =
        CharacterHolder(ItemCharacterBinding.inflate(LayoutInflater.from(context), parent, false))

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val rmCharacter = this.getItem(position)
        if (rmCharacter != null){
            holder.binding.apply {
                this.TxCharacterName.text = rmCharacter.name
                this.IvCharacterPhoto.load(rmCharacter.image)
                this.IvCharacterGender.setImageResource(
                    if (rmCharacter.gender.lowercase() == "male")
                        R.drawable.ic_male
                    else
                        R.drawable.ic_female
                )
                this.TxCharacterSpecies.text = rmCharacter.species
            }
        }
    }

    class RickAndMortyCharacterDiff : DiffUtil.ItemCallback<RickAndMortyCharacter>() {
        override fun areItemsTheSame(oldItem: RickAndMortyCharacter, newItem: RickAndMortyCharacter): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: RickAndMortyCharacter, newItem: RickAndMortyCharacter): Boolean = oldItem == newItem
    }
}