package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

import java.util.List;

/**
 * @author ${author}
 * @since ${date}
 */
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 新增
     *
     * @param ${table.entityPath}
     */
    void create(${entity} ${table.entityPath});

    /**
     * 删除
     *
     * @param id 主键id
     */
    void delete(Integer id);

    /**
     * 修改
     *
     * @param ${table.entityPath}
     */
    void edit(${entity} ${table.entityPath});


    /**
     * 列表(全部)
     *
     * @return
     */
    List<${entity}> listAll();

    /**
    * 通过id获取数据
    *
    * @param id 主键id
    * @return
    */
${entity} findById(Integer id);
}