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

    @PostMapping("/tareas/{tareaId}")
    public ResponseEntity<CategoriaDTO> guardarCategoria(@PathVariable(value = "tareaId") long tareaId,@RequestBody CategoriaDTO categoriaDTO){
        return new ResponseEntity<>(categoriaServicio.crearCategoria(tareaId, categoriaDTO), HttpStatus.CREATED);

    }


    /* @PostMapping("/categorias/{categoriaId}")
    public ResponseEntity<TareasDTO> guardarTarea(@PathVariable(value = "categoriaId") long categoriaId, @RequestBody TareasDTO tareasDTO) {
        return new ResponseEntity<>(tareaServicio.crearTarea(categoriaId, tareasDTO), HttpStatus.CREATED);
    }  */

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
    @GetMapping("/tareas/{tareaId}")
    public List<CategoriaDTO> listarCategoriaPorTareaId(@PathVariable(value = "tareaId") Long tareaId){
        return categoriaServicio.obtenerCategoriasPorTareasId(tareaId);
    }


    /* @GetMapping("/publicaciones/{publicacionId}/comentarios/{id}")
	public ResponseEntity<ComentarioDTO> obtenerComentarioPorId(@PathVariable(value = "publicacionId") Long publicacionId,@PathVariable(value = "id") Long comentarioId){
		ComentarioDTO comentarioDTO = comentarioServicio.obtenerComentarioPorId(publicacionId, comentarioId);
		return new ResponseEntity<>(comentarioDTO,HttpStatus.OK);
	} */

}
