package com.db.assignment.assignment.controller;

import com.db.assignment.assignment.exception.NaceNotFoundException;
import com.db.assignment.assignment.service.FileUploadService;
import com.db.assignment.assignment.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "FileUploadController", description = "REST APIs related to Nace Entity!!!!")
@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value="/putNaceDetails", method= RequestMethod.POST )
    public @ResponseBody
    String putNaceDetails(){
        fileUploadService.singleSave();
            return "Data saved successfully";
    }

    @ApiOperation(value = "Get specific Nace details based on order number ", response = OrderVO.class, tags = "getNaceDetails")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value="/getNaceDetails/{orderNo}", method= RequestMethod.POST, produces = "application/json" )
    public @ResponseBody
    ResponseEntity<OrderVO> getNaceDetails(@PathVariable Long orderNo){
        OrderVO orderVO=null;
        try {
             orderVO = fileUploadService.fetchNaceDetails(orderNo);
            orderVO.setMessage("Found");
        } catch(NaceNotFoundException ex){
            orderVO=new OrderVO();
            orderVO.setMessage(ex.getErrorMessage());
            return new ResponseEntity<OrderVO>(orderVO,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderVO>(orderVO, HttpStatus.OK);
    }

}
