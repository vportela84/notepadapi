package br.com.vinicius.notepadapi.controller

import br.com.vinicius.notepadapi.model.Nota
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import br.com.vinicius.notepadapi.service.NotaService

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
class NotaController {
    @Autowired
    lateinit var notaService: NotaService
    @GetMapping
    fun buscarTodos(): List<Nota> {
        return notaService.buscarTodas()
    }
    @GetMapping(value = "/titulo/{titulo}")
    fun buscar(@PathVariable(value = "titulo") titulo: String):
            Nota {
        return notaService.buscar(titulo)
    }
    @PostMapping
    fun salvar(@RequestBody nota: Nota) {
        notaService.salvar(nota)
    }
}