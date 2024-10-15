package com.aulaopet.animacao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.aulaopet.animacao.databinding.FragmentBotaoBinding

class FragmentBotao : Fragment(R.layout.fragment_botao) {
private lateinit var binding: FragmentBotaoBinding

//sobrescrevendo método que roda depois da criação da view

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBotaoBinding.bind(view)

        pulsa(binding.animacao)

        binding.botaofragment.setOnClickListener {
            binding.botaofragment.isVisible = false

            // uma forma de passar a função como parâmetro de referência, os dois pontos atribuem a função

            iniciaexplosao(binding.botaofragment, ::navegadestino)
        }
    }

    private fun navegadestino(){
        findNavController().navigate(R.id.action_fragmentBotao_to_destino)
    }

    private fun pulsa(view: View) = scaleDown(view)

    private fun scaleUp(view:View)
    {
        view.animate()
            .scaleX(2F)
            .scaleY(2F)
            .setDuration(1500L)
            .withEndAction {kotlin.run{scaleDown(view)}}
            .start()
    }

    private fun scaleDown(view:View)
    {
        view.animate()
            .scaleX(0.5F)
            .scaleY(0.5F)
            .setDuration(1500L)
            .withEndAction {kotlin.run{scaleUp(view)}}
            .start()
    }

    // declara a função recebenco a view (no caso o botão) e a função parametrizada (navega destino),
    // retorna um UNIT que é equivalenta a tipo nulo em outras linguagens

    private fun iniciaexplosao(view: View, endAction: () -> Unit) = shrink(view,endAction)


    private fun shrink(view: View, endAction: () -> Unit){
        view.animate()
            .scaleX(0.3F)
            .scaleY(0.3F)
            .setDuration(600L)
            .withEndAction {kotlin.run{explodir(view, endAction)}}
            .start()
    }


    private fun explodir(view: View, endAction: () -> Unit) {
        view.animate()
            .scaleX(4F)
            .scaleY(4F)
            .setDuration(300L)
            .withEndAction {kotlin.run { endAction()}}
            .start()
    }



}