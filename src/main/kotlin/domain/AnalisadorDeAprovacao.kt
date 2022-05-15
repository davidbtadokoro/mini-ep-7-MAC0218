package domain

import domain.criterios.Basico
import domain.criterios.CriterioDeAprovacao

class AnalisadorDeAprovacao {

    // O critério default é o básico.
    private var criterio: CriterioDeAprovacao = Basico()

    fun defineCriterio(criterio: CriterioDeAprovacao) {
        this.criterio = criterio
    }

    fun fechaBoletim(boletim: Boletim): BoletimFechado {
        return BoletimFechado(
            mediaEPs = boletim.mediaEPs,
            mediaMiniEPs = boletim.mediaMiniEPs,
            mediaFinal = criterio.mediaFinal(boletim),
            foiAprovado = criterio.estaAprovado(boletim)
        )
    }

}