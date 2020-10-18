package com.cristianerm.rainbow

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

        val spinner: Spinner = findViewById(R.id.caridade_periodo_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.filter,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
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
