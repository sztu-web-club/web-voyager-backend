package io.github.sztuwebclub.webvoyager.constant.model;

import io.github.sztuwebclub.webvoyager.constant.MessageEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T extends Serializable> implements Serializable {
    private Integer total;
    private Integer start;
    private Integer size;
    private Integer pageCount;
    private boolean hasPrev;
    private boolean hasNext;
    private List<T> list;

    public PageResult(Integer total, Integer start, Integer size, List<T> resultList) {
        this.total = total;
        this.start = start;
        this.size = size;
        this.list = resultList;

        if(size == null){
            throw new BaseException(MessageEnum.WRONG_PARAMETER.toString());
        }

        if(total%size == 0){
            this.pageCount = total/size;
        }else {
            this.pageCount = total/size + 1;
        }
        this.hasPrev = this.start > this.size;
        this.hasNext = this.start + this.size < this.total;
    }
}