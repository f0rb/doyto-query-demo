package win.doyto.query.demo.common;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import win.doyto.query.core.PageQuery;

/**
 * MyPageQuery
 *
 * @author f0rb on 2021-03-07
 */
@NoArgsConstructor
@SuperBuilder
public class MyPageQuery extends PageQuery {

    @Override
    public int calcOffset() {
        Integer pageNumber = getPageNumber();
        return pageNumber != null ? getPageSize() * Math.max(pageNumber - 1, 0) : 0;
    }

}
