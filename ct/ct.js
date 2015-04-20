$(document).ready(function(){
 var $deckStatus = $(".deck-status");
 var $footer = $('<div class="footer"></div>');
 var author = $('meta[name=author]').attr('content');
 var keyword = $('meta[name=keywords]').attr('content');
 $footer.append($deckStatus.html());
 //$footer.append("<span class='ctauthor'>"+author+"</span>");
 $footer.append("<span class='ctkeyword'>"+keyword+"</span>");
 $footer.append("<span class='ctlogo'><img src='ct/logo.png'/></span>");
 $deckStatus.empty();
 $footer.appendTo($deckStatus);
 $(document.head).append('<script src="http://'
 + location.host.split(':')[0]
 + ':35729/livereload.js"></script>');
});
