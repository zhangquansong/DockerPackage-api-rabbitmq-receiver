package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@Transactional
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {


    @Autowired
    private ${table.mapperName} ${table.entityPath}Mapper;



    /**
     * 新增
     *
     * @param ${table.entityPath}
     */
    @Override
    public void create(${entity} ${table.entityPath}) {
        this.insertOrUpdate(${table.entityPath});
    }

    /**
     * 删除
     *
     * @param id 主键id
     */
    @Override
    public void delete(Integer id) {
        this.deleteById(id);
    }

    /**
     * 修改
     *
     * @param ${table.entityPath}
     */
    @Override
    public void edit(${entity} ${table.entityPath}) {
        this.updateById(${table.entityPath});
    }

    /**
     * 查询列表
     *
     * @return
     */
    @Override
    public List<${entity}> listAll() {
        return this.selectList(null);
    }

    /**
    * 查询详情
    *
    * @param id 主键id
    * @return
    */
    @Override
    public ${entity} findById(Integer id) {
        return this.selectById(id);
    }

}