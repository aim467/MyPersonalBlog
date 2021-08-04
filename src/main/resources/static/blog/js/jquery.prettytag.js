/*  Plugin: prettyTag (Auto Colored Tags)
 *   Frameworks: jQuery 3.3.1
 *   Author: Asif Mughal
 *   GitHub: https://github.com/CodeHimBlog
 *   URL: https://www.codehim.com
 *   License: MIT License
 *   Copyright (c) 2018 - Asif Mughal
 */
/* File: jquery.prettytag.js */

(function($){
    $.fn.prettyTag = function(options) {
        var setting = $.extend({
            randomColor: true, //false to off random color
            tagicon: true, //false to turn off tags icon
            tagURL: "#", //url that will be assigned to new tags when user enter a tag name
        }, options);

        return this.each(function() {
            var $target,
                tagsManager,
                newTag;


            tagsManager = []; //an array to store new tag name and URL
            newTag = -1;
            $target = this;

            $($target).addClass(setting.jTagMode);


            $(".codehim-input-tags").on('input', function(){

//creating new cloud tags
                var tList = document.createElement("li");

//to set link for new tags
                var tagLink = document.createElement("a");

                var tagName = $(this).val();

                var tagComplete = tagName.search(",");

                if ( tagComplete > 0){

                    newTag += 1;
                    var newTagName = tagName.slice(0, tagComplete).concat(" ");

                    var $thisTag = {
                        'tagName' : newTagName,
                        'tagURL' :  setting.tagURL+newTagName.toLowerCase(),
                    };

                    tagsManager.push($thisTag);

                    $(tagLink)
                        .attr("href", tagsManager[newTag].tagURL)
                        .html(tagsManager[newTag].tagName)
                        .appendTo(tList);

                    $(tList).append("<span></span>");

                    $(".tags")
                        .append(tList);

                    coloredTags();

                    closeTag();
                    $(this).val('');
                    tagComplete = null;

                }
            }); //end tags input function


//add font awesome icon
            if (setting.tagicon == true){
                var eachTag = $($target).find("a");
                var $ti = document.createElement("i");
                $($ti).addClass("fa fa-tags").prependTo(eachTag);

            }
// close tag
            function closeTag(){

                var closeAbleTag = $(".cloud-tags").find("span");

                $(closeAbleTag).html("&times;");

                $(closeAbleTag).click(function(){

                    $(this).parent().remove();

                });
            }

            coloredTags();
//function to make tags colorful
            function coloredTags(){
                var totalTags = $(".cloud-tags").find("li").length; //to find total cloud tags
                var mct = $(".cloud-tags").find("a");  //select all tags links to make them colorful

                /*Array of Colors */
                var tagColor = ["#ff0084", "#ff66ff","#43cea2","#D38312","#73C8A9","#9D50BB",
                    "#780206","#FF4E50","#ADD100",
                    "#0F2027","#00c6ff", "#81D8D0", "#5CB3FF", "#95B9C7", "#C11B17", "#3B9C9C" , "#FF7F50", "#FFD801", "#79BAEC", "#F660AB", "#3D3C3A", "#3EA055"];

                var tag = 0; var color = 0; //assign colors to tags with loop, unlimited number of tags can be added
                do {
                    if(color > 21) {color = 0;} //Start again array index if it reaches at last

                    if (setting.randomColor == true){
                        var $rc = Math.floor(Math.random() *22);
                        $(mct).eq(tag).css({
                            //tags random color
                            'background' : tagColor[$rc] });
                    }
                    else {
                        $(mct).eq(tag).css({
                            //tags color in a sequence
                            'background' : tagColor[color] });
                    }

                    tag++;
                    color++;
                } while( tag <= totalTags)

            }

        });
    };

})(jQuery);
/*   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. */