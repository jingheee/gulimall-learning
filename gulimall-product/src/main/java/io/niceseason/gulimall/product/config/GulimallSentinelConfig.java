package io.niceseason.gulimall.product.config;

//@Configuration
//public class GulimallSentinelConfig{
//    @Bean
//    public UrlBlockHandler urlBlockHandler() {
//        return new UrlBlockHandler() {
//            @Override
//            public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
//                R r = R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(), BizCodeEnum.TO_MANY_REQUEST.getMsg());
//                response.setContentType("application/json;charset=utf-8");
//                response.getWriter().write(JSON.toJSONString(r));
//            }
//        };
//    }
//}
