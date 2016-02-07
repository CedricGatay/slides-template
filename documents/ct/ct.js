$(document).ready(function(){
 var $deckStatus = $(".deck-status");
 var $footer = $('<div class="footer"></div>');
 var author = $('meta[name=author]').attr('content');
 var keyword = $('meta[name=keywords]').attr('content');
 $footer.append($deckStatus.html());
 //$footer.append("<span class='ctauthor'>"+author+"</span>");
 $footer.append("<span class='ctkeyword'>"+keyword+"</span>");
 $footer.append("<span class='ctlogo'><img class='ct' src='ct/logo.png'/></span>");
 $deckStatus.empty();
 $footer.appendTo($deckStatus);
 prepareAsyncDemos();

 function prepareAsyncDemos() {
  var setResponseContentInModal = function(e){
   return function (d) {
    var modal = createModal(e);
    var modalContent = modal.find("pre");
    modalContent.text(modalContent.text() + JSON.stringify(d) + '\n');
   }
  };

  $(".get").each(function (_, e) {
   var $e = $(e);
   var $h2 = $e.siblings("h2");
   var $icon = $("<i class='header-action icon-globe'></i>");
   $h2.append($icon);
   var url = $(e).find("a").attr("href");
   if ($e.hasClass("blank")){
    $icon.click(function() {
     window.open(url, '_blank');
    });
   }else {
    $icon.click(function () {
     $.ajax(url).then(setResponseContentInModal(e));
    });
   }
  });

  $(".post").each(function (_, e) {
   var $h2 = $(e).siblings("h2");
   var i = $("<i class='header-action icon-envelope'></i>");
   $h2.append(i);
   i.click(function () {
    var url = $(e).find("a").attr("href");
    $.ajax({url: url, method: 'POST'}).then(setResponseContentInModal(e));
   });
  });

  $('.ct').click(function(){
   $('.modal').remove();
  })
 }

 function createModal(e) {
  var $deck = $(e).parents(".deck-current");
  var existingModal = $deck.find('.modal');
  if (existingModal.length === 0) {
   var modal = $("<div class='modal'><pre class='response'></pre></div>")
   $deck.append(modal);
   return modal;
  }
  return existingModal;
 }
});
