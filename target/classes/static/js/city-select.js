$(document).ready(function() {

	$('.selectpicker').selectpicker({
		"noneResultsText" : "没有相关城市 {0}"
	});

	$(".form-control").on('keyup', function(e) {
		var keynum;
		if (window.event) { // IE
			keynum = e.keyCode;
		} else if (e.which) { // Netscape/Firefox/Opera
			keynum = e.which;
		}
		/* <![CDATA[ */
		if (keynum < 37 || keynum > 40) {
			searchCity(this.value);
		}
		/* ]]> */
	});

	function searchCity(key) {
		if (key == null || key == "")
			return;
		$.ajax({
			type : 'Get',
			url : '/search_city/' + key,
			dataType : "Json",
			success : function(data) {
				$('.selectpicker').html("");
				if (data == null)
					return;

				var optionString = "";
				for ( var i in data) {
					option = $("<option></option>");
					option.attr("value", data[i].pinyin);
					option.html(data[i].name);
					$('.selectpicker').append(option);
				}

				$('.selectpicker').selectpicker("refresh");
			}
		})

	}
	
	//页面加载热门城市
	metropolisCity();
	
	
});