package com.vwardi.restapitemplate.controller;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import com.vwardi.restapitemplate.contract.request.CreateNewBasicRequest;
import com.vwardi.restapitemplate.contract.request.UpdateBasicRequest;
import com.vwardi.restapitemplate.contract.response.CreateNewBasicResponse;
import com.vwardi.restapitemplate.contract.response.GetBasicResponse;
import com.vwardi.restapitemplate.contract.response.UpdateBasicResponse;
import com.vwardi.restapitemplate.model.Basic;
import com.vwardi.restapitemplate.service.BasicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping("/api/v1/basics")
public class BasicController {

    private final BasicService basicService;

    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

    @Operation(summary = "Create a new basic")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Basic created", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CreateNewBasicResponse.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid values", content = @Content)})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateNewBasicResponse createNewBasic(@Valid @RequestBody CreateNewBasicRequest createNewBasicRequest) {
        Basic newBasic = createNewBasicRequest.toModel();
        Basic savedBasic = this.basicService.save(newBasic);
        return new CreateNewBasicResponse(savedBasic);
    }

    @Operation(summary = "Update a existing basic")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Basic created", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CreateNewBasicResponse.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid values", content = @Content)})
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateBasicResponse updateBasic(@ApiParam("A valid id") @PathVariable Long id, @Valid @RequestBody UpdateBasicRequest updateBasicRequest) {
        Basic newBasic = updateBasicRequest.toModel();
        Basic savedBasic = this.basicService.save(newBasic);
        return new UpdateBasicResponse(savedBasic);
    }

    @Operation(summary = "Get basic by its id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found something", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = GetBasicResponse.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
        @ApiResponse(responseCode = "404", description = "Something not found", content = @Content)})
    @GetMapping("/{id}")
    public GetBasicResponse getBasicById(@ApiParam("A valid id") @PathVariable Long id) {
        final Basic basic = basicService.getBasicById(id);
        return new GetBasicResponse(basic);
    }

    @Operation(summary = "Get all basics by its id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found all basics", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
        @ApiResponse(responseCode = "404", description = "Nothing not found", content = @Content)})
    @GetMapping
    public List<GetBasicResponse> getAllBasics() {
        return basicService.getAllBasics().stream()
            .map(GetBasicResponse::new)
            .collect(Collectors.toList());
    }

}
