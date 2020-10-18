package com.cristianerm.rainbow

data class CaridadeInformation(

    var nome_caridade: String,

    var descricao_caridade: String

) {

    override fun toString(): String {
        return "BlogPost(nome_caridade='$nome_caridade', descricao_caridade='$descricao_caridade')"
    }


}