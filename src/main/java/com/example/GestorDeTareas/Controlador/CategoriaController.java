package com.example.GestorDeTareas.Controlador;

import com.example.GestorDeTareas.DTO.CategoriaDTO;
import com.example.GestorDeTareas.DTO.TareasDTO;
import com.example.GestorDeTareas.Servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServicio categoriaServicio;

    @PostMapping
    public ResponseEntity<CategoriaDTO> guardarCategoria(@RequestBody CategoriaDTO categoriaDTO){

        CategoriaDTO categoriaDto = categoriaServicio.crearCategoria(categoriaDTO);
        return new ResponseEntity<>(categoriaDTO, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> editarCategoria(@PathVariable (name = "id") long id, @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoriaParaEditar = categoriaServicio.actualizarCategoria(id, categoriaDTO);

        return new ResponseEntity<>(categoriaParaEditar, HttpStatus.OK);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable (name = "id" )Long id){
        categoriaServicio.eliminarCategoria(id);
        return new ResponseEntity<>("Se ha eliminado con exito la categoria", HttpStatus.OK);

    }
    @GetMapping
    public List<CategoriaDTO> listarCategorias(){
        return categoriaServicio.obtenerTodasLasCategorias();
    }

}
