package com.wangzhen.spbelasticsearchinaction.controller;

import com.wangzhen.spbelasticsearchinaction.domain.es.EsBlog;
import com.wangzhen.spbelasticsearchinaction.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BlogController
 * @Description
 * @Author wangzhen
 * @Date 2018/11/5 下午8:26
 **/
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @GetMapping
    public List<EsBlog> list(@RequestParam(value="title",required=false,defaultValue="") String title,
                             @RequestParam(value="summary",required=false,defaultValue="") String summary,
                             @RequestParam(value="content",required=false,defaultValue="") String content,
                             @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                             @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize) {

        // 数据在 Test 里面先初始化了，这里只管取数据
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<EsBlog> page = esBlogRepository.findByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);

        return page.getContent();
    }
}
