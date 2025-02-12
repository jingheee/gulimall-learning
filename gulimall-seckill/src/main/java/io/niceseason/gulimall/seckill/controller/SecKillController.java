package io.niceseason.gulimall.seckill.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.niceseason.common.utils.R;
import io.niceseason.gulimall.seckill.Service.SecKillService;
import io.niceseason.gulimall.seckill.to.SeckillSkuRedisTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SecKillController {

    @Autowired
    private SecKillService secKillService;

    @Value("${server.port}")
    private String port;

    /**
     * 当前时间可以参与秒杀的商品信息
     *
     * @return
     */
    @GetMapping(value = "/getCurrentSeckillSkus")
    @ResponseBody
    @SentinelResource(value = "sec", blockHandler = "block")
    public R getCurrentSeckillSkus() throws InterruptedException {

        //获取到当前可以参加秒杀商品的信息
//        for (int i = 0; i < 10000; i++) {
        List<SeckillSkuRedisTo> vos = secKillService.getCurrentSeckillSkus();

//        }

        return R.ok().setData(port);
    }

    public R block(BlockException e) {
        return R.ok().setData(e.getMessage());
    }

    @ResponseBody
    @GetMapping(value = "/getSeckillSkuInfo/{skuId}")
    public R getSeckillSkuInfo(@PathVariable("skuId") Long skuId) {
        SeckillSkuRedisTo to = secKillService.getSeckillSkuInfo(skuId);
        return R.ok().setData(to);
    }


    @GetMapping("/kill")
    public String kill(@RequestParam("killId") String killId,
                       @RequestParam("key")String key,
                       @RequestParam("num")Integer num,
                       Model model) {
        String orderSn= null;
        try {
            orderSn = secKillService.kill(killId, key, num);
            model.addAttribute("orderSn", orderSn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }


}
