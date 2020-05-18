package com.example.projpaint3.FragmentsApp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projpaint3.ExibirEventoActivity
import com.example.projpaint3.Model.Evento
import com.example.projpaint3.Model.Usuario

import com.example.projpaint3.R
import kotlinx.android.synthetic.main.card_view_evento.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var usuarios = mutableListOf(
            Usuario("elias","qwert","dsoaods",icone = 6),
            Usuario("Roberto","qwert","dsoaods",icone = 8),
            Usuario("ZE","qwert","dsoaods",icone = 9),
            Usuario("Rodrigo","qwert","dsoaods",icone = 3))

        var usuarios2 = mutableListOf(
            Usuario("Mario","qwert","dsoaods",icone = 11),
            Usuario("Biel","qwert","dsoaods",icone = 12),
            Usuario("Robs","qwert","dsoaods",icone = 1),
            Usuario("elias1","qwert","dsoaods",icone = 5),
            Usuario("elias2","qwert","dsoaods",icone = 7),
            Usuario("elias3","qwert","dsoaods",icone = 2),
            Usuario("elias2","qwert","dsoaods",icone = 4))

        var evento1 = Evento(
            1,"Tijuquinha","Tijuca",usuarios,usuarios,
            "descricao1231gydr67tyuijovdr6tyuijjbhvgdrtfyguh23wsda",Usuario("elias",
                "dasdsas","fasdad"), "27/2","12:00")

        var evento2 = Evento(
            2,"Paintball2","Botafogo",usuarios2,usuarios,
            "descricaokbuterstdygihjojyt123123wsda",Usuario("elias",
                "dasdsas","dasdasda"), "25/2","18:00")

        var evento3 = Evento(
            2,"Paintball26346","Barra",usuarios2,usuarios2,
            "descrihguiuhihiuuhugvrdtgyuhijokoiutydrcao13wsda",Usuario("elias","elias",
                "dasdsas",3), "7/2","10:00")

        var lista_eventos : MutableList<Evento> = mutableListOf(evento1,evento2,evento3)

        class EventoHomeAdapter(var lista_eventos : MutableList<Evento>) : RecyclerView.Adapter<EventoHomeAdapter.EventoViewHolder>(){

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
                var v = LayoutInflater.from(parent.context).inflate(R.layout.card_view_evento,parent,false)
                return EventoViewHolder(v)
            }

            override fun getItemCount(): Int = lista_eventos.size

            override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
                holder.bind(lista_eventos[position])
                holder.onClickItem(lista_eventos[position])
            }

            inner class EventoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
                fun bind(evento : Evento){

                    itemView.evento_nome_txt.text = evento.nome
                    itemView.evento_local_txt.text = evento.local
                    itemView.data_evento_txt.text = evento.data
                    itemView.horario_evento_txt.text = evento.horario_inicio
                    itemView.participantes_evento_txt.text = evento.participantesTotais().toString()

                }

                fun onClickItem(evento:Evento){
                    itemView.setOnClickListener {
                        var intent = Intent(this@HomeFragment.requireContext(),ExibirEventoActivity::class.java)
                        intent.putExtra("evento", evento)
                        startActivity(intent)
                    }
                }
            }
        }



        rcy_home_eventos.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        rcy_home_eventos.adapter = EventoHomeAdapter(lista_eventos)

    }
}
