package com.myc.erpsystem.controller.department;

import com.myc.erpsystem.model.Position;
import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.service.basic.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/9 15:49
 * @PackageName:com.myc.erpsystem.controller
 * @ClassName: PositionController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/dppo/pos")
public class PositionController {
    @Autowired
    PositionService positionService;
    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.list();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {

        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updatePositions(@RequestBody Position position) {
        boolean b = positionService.updateById(position);
        if ( b) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id) {
        boolean b = positionService.removeById(id);

        if (b) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @DeleteMapping("/")
    public RespBean deletePositionsByIds(Integer[] ids) {
        boolean b = positionService.removeByIds(Arrays.asList(ids));
        if (b) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
