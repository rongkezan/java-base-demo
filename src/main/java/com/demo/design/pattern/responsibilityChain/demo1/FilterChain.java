package com.demo.design.pattern.responsibilityChain.demo1;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    private List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Msg msg){
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)) return false;
        }
        return true;
    }
}
