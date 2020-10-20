jQuery(document).ready(function($) {
    "use strict"


    // ------- Navigation ------- //
    /*if ($('ul.nav li.dropdown').length) {
        $('ul.nav li.dropdown').on('hover', function() {
            $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
        }, function() {
            $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
        });
    }*/
    // ------- Navigation End ------- //


    // ------- Home Slider Start ------- //
    /*if ($('#home-slider').length) {
        $('#home-slider').owlCarousel({
            loop: true,
            margin: 0,
            nav: false,
            items: 1,
            autoplay: true,

        })
    }*/
    // ------- Home Slider End ------- //


    // ------- Home Slider Start ------- //
    /*if ($('#highlight-slider').length) {
        $('#highlight-slider').owlCarousel({
            loop: true,
            margin: 5,
			dots:false,
            responsiveClass: true,
            responsive: {
                0: {
                    items: 1,
                    nav: true,
                    loop: false,
                },
                600: {
                    items: 2,
                    nav: true,
                    loop: false,
                },
                1000: {
                    items: 4,
                    nav: true,
                    loop: false
                }
            }
        })
    }*/
    // ------- Home Slider End ------- //


    // ------- Home Slider Start ------- //
    /*if ($('#highlight-slider-2').length) {
        $('#highlight-slider-2').owlCarousel({
            loop: true,
            margin: 0,
            dots: false,
            responsiveClass: true,
            responsive: {
                0: {
                    items: 1,
                    nav: true,
                    loop: false,
                },
                700: {
                    items: 2,
                    nav: true,
                    loop: false,
                },
                1000: {
                    items: 3,
                    nav: true,
                    loop: false
                }
            }
        })
    }*/
    // ------- Home Slider End ------- //



    // ------- Pretty Photo Start ------- // 
    if ($('.gallery').length) {
        $("area[data-rel^='prettyPhoto']").prettyPhoto();
        $(".gallery:first a[data-rel^='prettyPhoto']").prettyPhoto({
            animation_speed: 'normal',
            theme: 'light_square',
            slideshow: 3000,
            autoplay_slideshow: false
        });

    }
    // ------- Pretty Photo End ------- // 


   




    // ------- Event Slider Start ------- //
    if ($('.recent-event-slider').length) {
        $('.recent-event-slider').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            arrows: false,
        });
        $('.recent-event-slider-nav').slick({
            slidesToShow: 4,
            slidesToScroll: 1,
            asNavFor: '.recent-event-slider',
            dots: false,
            centerMode: false,
            focusOnSelect: true,
            prevArrow: '<button class="slick-prev slick-arrow"><i class="fas fa-arrow-left"></i></button>',
            nextArrow: '<button class="slick-next slick-arrow"><i class="fas fa-arrow-right"></i></button>'
        });
    }
    // ------- Event Slider End ------- //	


    // ------- Home Slider Start ------- //
    /*if ($('#h3team-slider').length) {
        $('#h3team-slider').owlCarousel({
            loop: true,
            margin: 30,

            dots: false,
            responsiveClass: true,
            responsive: {
                0: {
                    items: 1,
                    nav: true
                },
                600: {
                    items: 2,
                    nav: true
                },
                1000: {
                    items: 2,
                    nav: true,
                    loop: false
                }
            }
        })
    }*/
    
    if ($('#news-slider').length) {
        $('#news-slider').owlCarousel({
            loop: true,
            dots: false,
            responsiveClass: true,
            nav: false,
            margin: 0,
            autoplay:true,
            autoplayTimeout:3000,
            autoplayHoverPause:true,
            responsive: {
            	0: {
            		items: 1,
                    loop: false,
                    nav: true,
                    margin: 0
                },
                430: {
                	items: 2,
                    loop: false,
                    nav: true,
                    margin: 0
                },
                600: {
                	items: 3,
                    loop: false,
                    nav: true,
                    margin: 0
                },
                1199: {
                    items: 4,
                    loop: false,
                    nav: true,
                    margin: 0
                }
            }
        })
    }
    
    if ($('#banner-video').length) {
        $('#banner-video').owlCarousel({
            responsiveClass: true,
            nav: true,
            responsive: {
            	0: {
            		items: 1,
                    loop: false,
                    nav: true,
                    margin: 0
                },
                430: {
                	items: 1,
                    loop: false,
                    nav: true,
                    margin: 0
                },
                600: {
                	items: 1,
                    loop: false,
                    nav: true,
                    margin: 0
                },
                1199: {
                    items: 1,
                    loop: false,
                    nav: true,
                    margin: 0
                }
            }
        })
    }
    // ------- Home Slider End ------- //



    // ------- Close Btn ------- //
    /*if ($('#closebtn').length) {
        $('#closebtn').on('click', function() {
            $('#closetopbar').slideUp().empty();
        });

        $(function() {
            $('#closetopbar').slideDown();
        });
    }*/
    // ------- Close Btn ------- //



    // ------- Events Counter ------- //
    /*if ($('#defaultCountdown').length) {
        var austDay = new Date();
        austDay = new Date(2019, 12, 18, 14);
        $('#defaultCountdown').countdown({
            until: austDay
        });
        $('#year').text(austDay.getFullYear());
    }*/


    // ------- Filter Gallery Start ------- //
    /*if ($('.filter-gallery').length) {
        if ($('.filter-gallery .isotope').length) {
            var $container = $('.filter-gallery .isotope');
            $container.isotope({
                itemSelector: '.item',
                transitionDuration: '0.6s',
                masonry: {
                    columnWidth: $container.width() / 12
                },
                layoutMode: 'masonry'
            });
            $(window).on("resize", function() {
                $container.isotope({
                    masonry: {
                        columnWidth: $container.width() / 12
                    }
                });
            });
        }
        if ($('.filter-gallery #filters').length) {
            $('.filter-gallery #filters').on('click', 'button', function() {
                var filterValue = $(this).attr('data-filter');
                $container.isotope({
                    filter: filterValue
                });
            });
            // change is-checked class on buttons
            $('.filter-gallery .button-group').each(function(i, buttonGroup) {
                var $buttonGroup = $(buttonGroup);
                $buttonGroup.on('click', 'button', function() {
                    $buttonGroup.find('.is-checked').removeClass('is-checked');
                    $(this).addClass('is-checked');
                });
            });

        }
    }*/

    // ------- Classic Gallery ------- //

    /*if ($('.classic-gallery').length) {
        if ($('.classic-gallery .isotope').length) {
            var $container = $('.classic-gallery .isotope');
            $container.isotope({
                itemSelector: '.item',
                transitionDuration: '0.6s',
                masonry: {
                    columnWidth: $container.width() / 12
                },
                layoutMode: 'masonry'
            });
            $(window).on("resize", function() {
                $container.isotope({
                    masonry: {
                        columnWidth: $container.width() / 12
                    }
                });
            });
        }
    }*/


    // ------- Filter Gallery End ------- //

    /*prettyPhoto
	************/
	$("a[rel^='prettyPhoto']").prettyPhoto({
	    social_tools: false, 
	    show_title:false, 
	    autoplay_slideshow: false, 
	    slideshow:3300
	});



    // ------- Testimonials Page Slider Start ------- //
    /*if ($('#h3testimonials').length) {
        $('#h3testimonials').owlCarousel({
            loop: true,
            margin: 30,
            responsiveClass: true,
            autoHeight: true,
            autoplay: true,
            center: true,
            responsive: {
                0: {
                    items: 1,
                },
                600: {
                    items: 2,
                },
                1000: {
                    items: 3,
                    loop: true,
                }
            }
        })
    }*/

    // ------- Testimonials 2nd Option ------- //

    /*if ($('#testimonials').length) {
        $('#testimonials').owlCarousel({
            loop: true,
            margin: 30,
            responsiveClass: true,
            autoHeight: true,
            autoplay: true,
            responsive: {
                0: {
                    items: 1,
                },
                600: {
                    items: 2,
                },
                1000: {
                    items: 4,
                    loop: true,
                }
            }
        })
    }*/
    // ------- Testimonials Page Slider End ------- //



    // ------- Counter Start ------- //
    /*if ($('.countdown').length) {
        var austDay = new Date();
        austDay = new Date(austDay.getFullYear() + 1, 1 - 1, 26);
        $('.countdown').countdown({
            until: austDay
        });
        $('#year').text(austDay.getFullYear());
    }*/
    // ------- Counter End ------- // 

    // ------- Search Overlay Start ------- //
    /*if ($('a[href="#search"]').length) {
        $(function() {
            $('a[href="#search"]').on('click', function(event) {
                event.preventDefault();
                $('#search').addClass('open');
                $('#search > form > input[type="search"]').focus();
            });
            $('#search, #search button.close').on('click keyup', function(event) {
                if (event.target == this || event.target.className == 'close' || event.keyCode == 27) {
                    $(this).removeClass('open');
                }
            });
            $('form').submit(function(event) {
                event.preventDefault();
                return false;
            })
        });
    }*/

    // ------- Search Overlay End ------- //
	
	 /*if ($('#dismiss, .overlay').length) {
       $('#dismiss, .overlay').on('click', function () {
       $('#sidebar').removeClass('active');
       $('.overlay').removeClass('active');
       });

       $('#sidebarCollapse').on('click', function () {
       $('#sidebar').addClass('active');
       $('.overlay').addClass('active');
       $('.collapse.in').toggleClass('in');
       $('a[aria-expanded=true]').attr('aria-expanded', 'false');
       });
	 }*/


}); //End
