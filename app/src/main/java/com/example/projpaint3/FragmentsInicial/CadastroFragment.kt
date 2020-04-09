package com.example.projpaint3.FragmentsInicial

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.projpaint3.Model.Usuario

import com.example.projpaint3.R
import com.example.projpaint3.ViewModel.UsuarioViewModel
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_cadastro.*

/**
 * A simple [Fragment] subclass.
 */
class CadastroFragment : Fragment() {

    private lateinit var usuarioViewModel_cadastro : UsuarioViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_cadastro_to_login.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
        }


        btn_cadastrar.setOnClickListener {

            Verificar_Dados_Invalidos()

//          Esse if verifica se todas os dados foram preenchidos corretamente e navega para a pagina de login

            if(edt_email_cadastro.text.toString().contains("@")
                && (edt_confirmaSenha_cadastro.text.toString() == edt_senha_cadastro.text.toString())
                && Verificar_string(edt_senha_cadastro.text.toString())
                && Verificar_string(edt_usuario_cadastro.text.toString())
            ){

                activity?.let{
                    usuarioViewModel_cadastro = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
                }

                var usuario = Usuario(
                    id = 1,
                    nome = edt_usuario_cadastro.text.toString(),
                    senha = edt_senha_cadastro.text.toString(),
                    email = edt_email_cadastro.text.toString(),
                    telefone = null,
                    icone = null,
                    partidas_ganhas = null,
                    partidas_perdidas = null
                )

                usuarioViewModel_cadastro.usuario = usuario

                findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
            }


        }
    }


    fun Verificar_Dados_Invalidos(){
        //          Torna as animacoes invisiveis quando apertado o botao, como se estivessem sendo reiniciadas

        anim_edt_usuario_cadastro.isVisible = false
        anim_edt_senha_cadastro.isVisible = false
        anim_edt_confirmarSenha_cadastro.isVisible = false
        anim_edt_email_cadastro.isVisible = false

//          Os quatro ifs a seguir sao para ativar as animacoes de alerta caso os dados preenchidos sejam invalidos

        if(!Verificar_string(edt_usuario_cadastro.text.toString())){
            anim_edt_usuario_cadastro.playAnimation()
            anim_edt_usuario_cadastro.isVisible = true
        }

        if(!Verificar_string(edt_senha_cadastro.text.toString())){
            anim_edt_senha_cadastro.playAnimation()
            anim_edt_senha_cadastro.isVisible = true
        }

        if(edt_confirmaSenha_cadastro.text.toString() != edt_senha_cadastro.text.toString()){
            anim_edt_confirmarSenha_cadastro.playAnimation()
            anim_edt_confirmarSenha_cadastro.isVisible = true
        }

        if(!edt_email_cadastro.text.toString().contains("@")){
            anim_edt_email_cadastro.playAnimation()
            anim_edt_email_cadastro.isVisible = true
        }
    }

//  Verifica se a palavra atende aos requisitos do cadastro
    fun Verificar_string(palavra : String) : Boolean{

        return !(palavra.contains(";")||palavra.contains(".")||
                palavra.contains(",")|| palavra.contains(" ")||
                palavra.contains("!")|| palavra.contains("?")||
                palavra.contains(":")|| !((palavra.length>=4) && (palavra.length <=18))
                )
    }
}
