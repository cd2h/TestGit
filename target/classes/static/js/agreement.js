 $(document).ready(function () {
/*点击给选中的文字添加背景*/
     $("#sidebar a").each(function () {
         var url = $(this).attr("href");
         $("#sidebar a").click(function () {
             var urlValue = $(this).attr("href");
             bushColor();
             if (url = urlValue) {
                 $(urlValue).css("background", "#f5f5f5");
             }
         })

     })
     function bushColor() {
         $("#sidebar a").each(function () {
             var url = $(this).attr("href");
             $(url).css("background", "#fff");
         })
     }
 });