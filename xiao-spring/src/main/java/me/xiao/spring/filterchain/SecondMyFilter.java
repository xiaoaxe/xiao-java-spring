package me.xiao.spring.filterchain;

import java.util.List;

/**
 * 第二个过滤
 *
 * @author pacman
 * @version 1.0
 * @date: 2017/11/23 14:34
 */

public class SecondMyFilter extends AbstractMyFilter {

    @Override
    public void doFilter(List<Integer> numbers) {
        numbers.remove(new Integer(2));
    }
}
