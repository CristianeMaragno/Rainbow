package com.cristianerm.rainbow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_functionalities.*
import kotlinx.android.synthetic.main.activity_main_functionalities.recyclerView_promotions
import kotlinx.android.synthetic.main.activity_revertido_caridade.*

class RevertidoCaridadeActivity : AppCompatActivity() {

    private lateinit var caridadeRecyclerViewAdapter: CaridadeRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revertido_caridade)

        back_to_main.setOnClickListener({
            val intent = Intent(this, MainFunctionalities::class.java)
            startActivity(intent)
        })

        recyclerView_promotions.apply {
            layoutManager = LinearLayoutManager(context)
            caridadeRecyclerViewAdapter = CaridadeRecyclerViewAdapter()
            adapter = caridadeRecyclerViewAdapter
        }

        val list = ArrayList<CaridadeInformation>()
        list.add(
            CaridadeInformation(
                "TransVest",
                "Projeto artístico-pedagógico que objetiva combater a transfobia e incluir travestis, transexuais e transgêneros na sociedade..."
            )
        )
        list.add(
            CaridadeInformation(
                "Instituto Cultura Arte Memória LGBT",
                "A criação de um Centro Cultural LGBT em Brasília é um projeto do Instituto Cultura Arte Memória LGBT, com previsão de inauguração em..."
            )
        )
        list.add(
            CaridadeInformation(
                "Grupo Dignidade",
                "Fundado em 1992, o Grupo Dignidade é pioneiro no estado do Paraná na área da promoção da cidadania LGBT (lésbicas, gays, bissexuais, travestis e transexuais)..."
            )
        )

        list.add(
            CaridadeInformation(
                "Adeh – Associação em Defesa dos Direitos Humanos",
                "ONG que atua desde 1993 no sentido da garantia de direitos, da promoção de saúde e da discussão no campo dos direitos humanos e das políticas LGBT..."
            )
        )

        list.add(
            CaridadeInformation(
                "Instituto Boa Vista",
                "O Instituto Boa Vista é uma ONG que criou uma rede solidária de cultura em Pernambuco. Sua principal estratégia é promover a criação de cursos de aprendizagem e capacitação..."
            )
        )

        caridadeRecyclerViewAdapter.submitList(list)
    }
}
