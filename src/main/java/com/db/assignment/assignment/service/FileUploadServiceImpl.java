package com.db.assignment.assignment.service;

import com.db.assignment.assignment.entity.OrderEntity;
import com.db.assignment.assignment.exception.NaceNotFoundException;
import com.db.assignment.assignment.repository.FileUploadRepository;
import com.db.assignment.assignment.vo.OrderVO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Optional;

@Service
public class FileUploadServiceImpl implements  FileUploadService{

    @Autowired
    private FileUploadRepository fileUploadRepository;
    @Override
    public void singleSave() {
        try {
            FileInputStream fis = new FileInputStream(new File("C:\\Assignment\\NACE_REV2_20211109_053938.xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            Iterator<Row> itr = sheet.iterator();

            System.out.println("The given file is");
            while (itr.hasNext()) {
                Row row = itr.next();
                if(row.getRowNum()!=0){
                    Iterator <Cell> cellIterator = row.cellIterator();
                    OrderEntity orderEntity=new OrderEntity();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                                setColumns(cell.getColumnIndex(),cell,orderEntity);


                    }
                    fileUploadRepository.save(orderEntity);
                }
                System.out.println("");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public OrderVO fetchNaceDetails(Long orderNo) throws NaceNotFoundException {
        Optional<OrderEntity> orderEntity=fileUploadRepository.findById(orderNo);
        if(orderEntity.isPresent()) {
            return OrderVO.mapOrder(orderEntity.get());
        } else{
            throw new NaceNotFoundException("Record Not found");
        }

    }

    private OrderEntity setColumns(int rowIndex, Cell cell, OrderEntity orderEntity) {

        switch(rowIndex){
            case 0:

                orderEntity.setOrderNo(Double.valueOf(cell.getNumericCellValue()).longValue());
                break;
            case 1:
                orderEntity.setLevel(Double.valueOf(cell.getNumericCellValue()).intValue());
                break;
            case 2:
                orderEntity.setCode(cell.getStringCellValue());
                break;
            case 3:
                orderEntity.setParent(cell.getStringCellValue());
                break;
            case 4:
                orderEntity.setParentDesc(cell.getStringCellValue());
                break;
            case 5:
                orderEntity.setIncludes(cell.getStringCellValue());
                break;
            case 6:
                orderEntity.setAlsoIncludes(cell.getStringCellValue());
                break;
            case 7:
                orderEntity.setExcludes(cell.getStringCellValue());
                break;
            case 8:
                orderEntity.setRulings(cell.getStringCellValue());
                break;
            case 9:
                orderEntity.setReferenceIsic(cell.getStringCellValue());
                break;
            default:
                break;
        }
        return orderEntity;

    }
}
