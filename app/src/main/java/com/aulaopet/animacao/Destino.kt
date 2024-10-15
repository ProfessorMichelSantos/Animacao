package com.aulaopet.animacao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aulaopet.animacao.databinding.FragmentDestinoBinding


class Destino : Fragment(R.layout.fragment_destino)
{
    private lateinit var binding: FragmentDestinoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDestinoBinding.bind(view)
    }
}