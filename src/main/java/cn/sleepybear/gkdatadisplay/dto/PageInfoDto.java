package cn.sleepybear.gkdatadisplay.dto;

import lombok.Data;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/21 19:49
 */
@Data
public class PageInfoDto {
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    private Integer pages;

    public PageInfoDto() {
    }

    public PageInfoDto(Integer pageNum, Integer pageSize, Integer total, Integer pages) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
    }

    public PageInfoDto(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

}
