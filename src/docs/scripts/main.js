var $ = require('jquery/dist/jquery');

var isWebKit = 'webkitAppearance' in document.documentElement.style,
  // zoom-based scaling causes font sizes and line heights to be calculated differently
  // on the other hand, zoom-based scaling correctly anti-aliases fonts during transforms (no need for layer creation hack)
  scaleMethod = isWebKit ? 'zoom' : 'transform',
  bespoke = require('bespoke'),
  bullets = require('bespoke-bullets'),
  classes = require('bespoke-classes'),
  fullscreen = require('bespoke-fullscreen'),
  multimedia = require('bespoke-multimedia'),
  hash = require('bespoke-hash'),
  nav = require('bespoke-nav'),
  overview = require('bespoke-overview'),
  scale = require('bespoke-scale'),
  onstage = require('bespoke-onstage'),
  blackout = require('bespoke-blackout');

var deck = bespoke.from({ parent: 'article.deck', slides: 'section' }, [
  classes(),
  nav(),
  fullscreen(),
  (scaleMethod ? scale(scaleMethod) : function(deck) {}),
  overview({ columns: 4 }),
  bullets('.build, .build-items > *:not(.build-items)'),
  hash(),
  onstage(),
  blackout(),
  multimedia()
]);

var off = deck.on('activate', function() {
  $(".modal").remove()
});

$(document).ready(function(){
  prepareAsyncDemos();
 
  function buildDemoURL(url){
      return window.location.protocol + "//" + window.location.hostname + ":8080/" + url
  }
 
  function prepareAsyncDemos() {
   var setResponseContentInModal = function(e){
    return function (d) {
     var modal = createModal(e);
     var modalContent = modal.find("pre");
     modalContent.text(modalContent.text() + JSON.stringify(d) + '\n');
     modal.css("height", parseInt(modal.css("height"),10) + 48);
    }
   };
   
   
   $(".get").each(function (_, e) {
     var $e = $(e);
     var $h2 = $e.siblings("h2");
     var $icon = $("<i class='header-action fa fa-globe get'></i>");
     $($e.parents()[0]).prepend($icon);
     var url = buildDemoURL($(e).find("a").attr("href"));
     if ($e.hasClass("blank")){
       $icon.click(function() {
         var $modal = $("<div class='modal iframe'><i class='fa fa-close'></i><iframe src='"+url+"'></iframe></div>")
         $modal.find(".fa-close").click(function(){
           $(".modal").remove()
          })
          $(e).parents(".deck").append($modal)
          //window.open(url, '_blank');
        });
      }else {
        $icon.click(function () {
          $.ajax({url: url, dataType: "text"}).then(setResponseContentInModal(e));
        });
      }
    });
    
    $(".post").each(function (_, e) {
    var $h2 = $(e).siblings("h2");
    var i = $("<i class='header-action fa fa-envelope post'></i>");
    $($(e).parents()[0]).prepend(i);
    i.click(function () {
      var url = buildDemoURL($(e).find("a").attr("href"));
      $.ajax({url: url, dataType: "text", method: 'POST'}).then(setResponseContentInModal(e));
    });
    });
 
  }
 
  function createModal(e) {
   var $deck = $(e).parents(".deck");
   var existingModal = $deck.find('.modal');
   if (existingModal.length === 0) {
    var modal = $("<div class='modal'><i class='fa fa-close'></i><pre class='response'></pre></div>")
    modal.find(".fa-close").click(function(){
      $(".modal").remove()
    })
    $deck.append(modal);
    return modal;
   }
   return existingModal;
  }
 });
 