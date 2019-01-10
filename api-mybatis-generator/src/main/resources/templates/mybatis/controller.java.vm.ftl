package ${package.Controller};

import com.clt.api.service.${table.serviceName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clt.api.param.${entity}CreateParam;
import com.clt.api.param.${entity}EditParam;
import com.clt.api.utils.RestResult;
import java.util.List;
import ${package.Entity}.${entity};
import org.springframework.beans.BeanUtils;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author ${author}
 * @since ${date}
 */
@RestController
@RequestMapping("/${table.entityPath}")
public class ${table.controllerName}  {

    @Autowired
    private  ${table.serviceName} ${table.entityPath}Service;

    /**
     * 新增
     *
     * @param ${table.entityPath}CreateParam
     */
    @PostMapping("/create")
    @ResponseBody
    public RestResult create(@Valid @RequestBody ${entity}CreateParam ${table.entityPath}CreateParam) {
${entity} ${table.entityPath}=new ${entity}();
        BeanUtils.copyProperties(${table.entityPath}CreateParam, ${table.entityPath});
${table.entityPath}Service.create(${table.entityPath});
        return RestResult.successResponse();
    }

    /**
     * 删除
     *
     * @param id 主键id
     */
    @PostMapping("/delete")
    @ResponseBody
    public RestResult delete(Integer id) {
${table.entityPath}Service.delete(id);
        return RestResult.successResponse();
    }

    /**
     * 修改
     *
     * @param ${table.entityPath}EditParam
     */
    @PostMapping("/edit")
    @ResponseBody
    public RestResult edit(@Valid @RequestBody ${entity}EditParam ${table.entityPath}EditParam) {
${entity} ${table.entityPath}=new ${entity}();
        BeanUtils.copyProperties(${table.entityPath}EditParam, ${table.entityPath});
${table.entityPath}Service.edit(${table.entityPath});
        return RestResult.successResponse();
    }

    /**
     * 查询列表
     *
     * @return
     */
    @PostMapping("/listAll")
    @ResponseBody
    public RestResult
<List<${entity}>> listAll() {
       return RestResult.successResponse(${table.entityPath}Service.listAll());
    }

    /**
    * 查询详情
    *
    * @param id 主键id
    * @return
    */
    @PostMapping("/findById")
    @ResponseBody
    public RestResult<${entity}> findById(@Param("id") Integer id) {
        return RestResult.successResponse(${table.entityPath}Service.findById(id));
    }

}