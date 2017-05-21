/*js
* @author: ggp
* */


/*
 * ************************************
 * JS using in user-form.jsp
 * *************************************
 */

//module that require  external parameters from jsp.
var userFormModule = (function($){

    var default_args ={
        "parent_host":"",
        "second_param":"deafult"
    };

    var _inherit = function(a, b) {
        var F;
        F = function() {};
        F.prototype = a;
        return $.extend(true, new F(), b);
    };

    function userFormModule(args) {

        args = _inherit(default_args, $.isPlainObject(args) ? args : {});
        console.log(args);

        /**
         * USER SERVICE DEFINITION
         * */
        var userSevices = (function () {

            function _isFunction(functionToCheck) {
                var getType = {};
                return functionToCheck && getType.toString.call(functionToCheck) === '[object Function]';
            }

            return {
                //call to the service to check if name is already taken.
                fieldAlreadyExist: function (field, name, cb) {
                    console.log(args.second_param);
                    $.ajax({
                        //url: "http://localhost:9090/crud-users-and-posts/validate/"+field+"?value="+name,
                        url: args.parent_host + "/validate/" + field + "?value=" + name,
                        success: function (data) {
                            if (_isFunction(cb)) {
                                cb(data);
                            }
                        },
                        error: function (err) {
                            console.log(err);
                        }
                    });
                }
            };
        })();

        /*
         * EMAIL VALIDATION
         * */
        function validateEmail(email) {
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(email);
        }

        $("#email_field")
            .focusout(function () {
                var email = $(this).val();
                if (email.length > 0) {
                    if (validateEmail(email)) {
                        $("#email_error_message").html("");
                        $("#email_error_message").hide();
                        userSevices.fieldAlreadyExist("email", email, function (isTaken) {
                            if (!isTaken) {
                                $("#email_error_message").hide();
                                $("#email_success_message").show();
                            } else {
                                $("#email_error_message").html("<p>This email is already registered</p>");
                                $("#email_error_message").show();
                                $("#email_success_message").hide();
                            }
                        });
                    } else {
                        $("#email_error_message").html("<p>invalid format</p>");
                        $("#email_error_message").show();
                    }
                } else {
                    $("#email_error_message").html("");
                    $("#email_error_message").hide();
                    $("#email_success_message").hide();
                }
            });

        $("#name_field")
            .focusout(function () {
                var name = $(this).val();
                if (name.length > 0) {
                    userSevices.fieldAlreadyExist("name", name, function (isTaken) {
                        if (!isTaken) {
                            $("#name_error_message").hide();
                            $("#name_success_message").show();
                        } else {
                            $("#name_error_message").html("<p>This name is already registered</p>");
                            $("#name_error_message").show();
                            $("#name_success_message").hide();
                        }
                    });
                } else {
                    $("#name_error_message").html("");
                    $("#name_error_message").hide();
                    $("#name_success_message").hide();
                }
            });
    }

    return {
        //public methods
        init : userFormModule
    }


})(jQuery);





