package org.example.comment.controller;

import lombok.RequiredArgsConstructor;
import org.example.comment.controller.contract.CommentControllerContract;
import org.example.comment.dto.CommentDTO;
import org.example.comment.dto.CommentSaveDTO;
import org.example.general.response.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Defines a RESTful API controller named CommentController. This controller handles comments.
 * It implements the CommentControllerContract interface and uses the methods provided by CommentControllerContract.
 * */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/comments")
public class CommentController {

    private final CommentControllerContract controllerContract;

    @GetMapping
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAll() {
        List<CommentDTO> all = controllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(all));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAllCustomer(@PathVariable Long id) {
        List<CommentDTO> allByCustomerId = controllerContract.findAllByCustomerId(id);
        return ResponseEntity.ok(RestResponse.of(allByCustomerId));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAllProduct(@PathVariable Long id) {
        List<CommentDTO> allByProductId = controllerContract.findAllByProductId(id);
        return ResponseEntity.ok(RestResponse.of(allByProductId));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CommentDTO>> save(@RequestBody CommentSaveDTO commentSaveDTO) {
        CommentDTO save = controllerContract.save(commentSaveDTO);
        return ResponseEntity.ok(RestResponse.of(save));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<CommentDTO>> delete(@PathVariable Long id) {
        controllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}