package com.andryanstgkr.desmart.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.andryanstgkr.desmart.constant.ActivityConstant;
import com.andryanstgkr.desmart.constant.MessageConstant;
import com.andryanstgkr.desmart.constant.ParamConstant;
import com.andryanstgkr.desmart.service.BaseService;
import com.andryanstgkr.desmart.utilities.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin()
public class BaseController<T> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseService<T, String> baseService;

    private T clazz ;


    public BaseController(T clazz){
        this.clazz = clazz;
    }

    @GetMapping("all")

    public ResponseEntity<Object> getAll() {
        List<T> baseList = new ArrayList<>();
        try {
            logger.info("Retrieving the object: " + clazz.toString());
            baseList = baseService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponseList(e.getMessage(), HttpStatus.BAD_REQUEST,
                    null, 0, 0, 0);
        }
        return ResponseHandler.generateResponseList(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK,
                (List<T>) baseList, baseList.size(), 0, 0);
    }

    @GetMapping("allitems")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Object> getAllItems(@PathVariable Optional<Integer> optPageNo,
            @PathVariable Optional<Integer> optPageSize, @PathVariable Optional<String> optSortBy,
            @PathVariable Optional<String> optSortType) {
        List<T> baseList = new ArrayList<>();
        Map<String, Object> baseMap = new HashMap<>();
        int totalPages = 0;
        int totalElements = 0;

        int pageNo = optPageNo.orElse(1);
        int pageSize = optPageSize.orElse(10);
        String sortBy = optSortBy.orElse("name");
        String sortType = optSortType.orElse("ASC");

        try {
            int retrievePageNo = pageNo - 1;

            baseMap = baseService.getAllByPagination(retrievePageNo, pageSize, Sort
                    .by(sortType.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
            baseList = (List<T>) baseMap.get(ParamConstant.RESULT_LIST);
            totalPages = Integer.valueOf(String.valueOf(baseMap.get(ParamConstant.TOTAL_PAGES)));
            totalElements =
                    Integer.valueOf(String.valueOf(baseMap.get(ParamConstant.TOTAL_ELEMENTS)));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponseList(e.getMessage(), HttpStatus.BAD_REQUEST,
                    null, 0, 0, 0);
        }
        return ResponseHandler.generateResponseList(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK,
                (List<T>) baseList, totalElements, pageNo, totalPages);
    }

    @GetMapping("allitems/pageNo={pageNo}&pageSize={pageSize}&SortBy={sortBy}&SortType={sortType}")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Object> getByPagination(@PathVariable int pageNo,
            @PathVariable int pageSize, @PathVariable String sortBy,
            @PathVariable String sortType) {
        List<T> baseList = new ArrayList<>();
        Map<String, Object> baseMap = new HashMap<>();
        int totalPages = 0;
        int totalElements = 0;
        try {
            int retrievePageNo = pageNo - 1;

            baseMap = baseService.getAllByPagination(retrievePageNo, pageSize == 0 ? 10 : pageSize,
                    Sort.by(sortType.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                            sortBy));
            baseList = (List<T>) baseMap.get(ParamConstant.RESULT_LIST);
            totalPages = Integer.valueOf(String.valueOf(baseMap.get(ParamConstant.TOTAL_PAGES)));
            totalElements =
                    Integer.valueOf(String.valueOf(baseMap.get(ParamConstant.TOTAL_ELEMENTS)));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponseList(e.getMessage(), HttpStatus.BAD_REQUEST,
                    null, 0, 0, 0);
        }
        return ResponseHandler.generateResponseList(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK,
                (List<T>) baseList, totalElements, pageNo, totalPages);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getBaseObjectById(@PathVariable("id") String id) {
        try {
            Optional<T> baseObject = baseService.getDetail(id);
            return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(),
                    ActivityConstant.GET, HttpStatus.OK, (T) baseObject.get());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), ActivityConstant.GET,
                    HttpStatus.BAD_REQUEST, null);
        }
    }

    @PostMapping("save")
    public ResponseEntity<Object> save(@RequestBody T t) {
        try {
            logger.info("Object to save: " + t.toString());
            String errorMessage = "";

            errorMessage = this.baseService.validate(t);

            if (!errorMessage.equals(MessageConstant.OK)) {
                return ResponseHandler.generateResponse(errorMessage, ActivityConstant.SAVE,
                        HttpStatus.OK, errorMessage);
            }
            T _t = baseService.save(t);

            return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(),
                    ActivityConstant.SAVE, HttpStatus.OK, _t);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), ActivityConstant.SAVE,
                    HttpStatus.BAD_REQUEST, null);
        }

    }

    @PutMapping("update/{id}")
    public ResponseEntity<Object> updateBaseEntity(@RequestBody T t,
            @PathVariable("id") String id) {
        try {
            T _t = baseService.update(t, ActivityConstant.UPDATE, id);
            return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(),
                    ActivityConstant.UPDATE, HttpStatus.OK, _t);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), ActivityConstant.UPDATE,
                    HttpStatus.BAD_REQUEST, null);
        }

    }

    @PutMapping("delete/{id}")
    public ResponseEntity<Object> patchBaseEntity(@RequestBody T t, @PathVariable("id") String id) {
        try {
            T _t = baseService.update(t, ActivityConstant.SOFT_DELETE, id);
            return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(),
                    ActivityConstant.UPDATE, HttpStatus.OK, _t);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), ActivityConstant.SOFT_DELETE,
                    HttpStatus.BAD_REQUEST, null);
        }
    }

    @PostMapping("hard-delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        try {
            Optional<T> t = this.baseService.getDetail(id);

            T _t = baseService.delete(t.get());
            return ResponseHandler.generateResponse("DELETED", ActivityConstant.HARD_DELETE,
                    HttpStatus.OK, _t);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), ActivityConstant.HARD_DELETE,
                    HttpStatus.BAD_REQUEST, null);
        }
    }
}
