$(document).ready(function () {
    countRewardNum();

    $(document).on("click", function () {
        $.post("/lottery/loadLotteryData", function (msg) {
            if (msg == "success") {
                location.reload();
            } else {
                alert("数据记载失败:" + msg);
            }
        })
    });

    $(document).on("click", ".delete", function () {
        var id = $(this).attr("data-id");
        $.post("/lottery/deleteUser", {
            id: id
        }, function (msg) {
            if (msg == "success") {
                alert("删除成功！");
                location.reload();
            } else {
                alert("删除失败:" + msg);
            }
        })
    });

    $(document).on("click", "#empty", function () {
        $.post("/lottery/emptyWinningList", function (msg) {
            if (msg == "success") {
                alert("清空成功！");
                location.reload();
            } else {
                alert("清空失败:" + msg);
            }
        })
    });

    clickNum = 0;
    var interval
    $(document).on("click", "#go", function () {
        var rewardType = $("input[name='rewardType']:checked").val();
        if (clickNum % 2 == 0) {
            $(".reward_go_area img").attr("src", "/resource/img/reward_img_stop.png");
            var $component = $(this);
            var id = $(this).attr("data-id");

            // $.get("/lottery/loadLotteryData", function () {
            //     alert("haha！");
            // });

            $.post("/lottery/loadAvailableUser", function (data) {
                if (data == null || data == "undefined" || data.length == 0) {
                    alert("已无可选取的人员！");
                    return false;
                }
                var nametext = "";
                interval = setInterval(function () {
                    nametext = data[Math.floor((Math.random() * data.length))];
                    $("#name_h1").text(nametext);
                }, 50);
            })
        } else {
            clearInterval(interval);
            var nametext = $("#name_h1").text();
            $.post("/lottery/setWinningList", {
                name: nametext,
                rewardType: rewardType
            }, function (msg) {
                if (msg == "success") {
                    $("#rewardType" + rewardType).append("<div>" + "<span class='person'>" + nametext + "</span>" + "</div>");
                    countRewardNum();
//					$component.attr("disabled",false);
                }
            });
            $(".reward_go_area img").attr("src", "/resource/img/reward_img.png");

        }
        clickNum++;

    });


    // $(document).on("click", ".person", function () {
    //     $this = $(this);
    //     var name = $this.text();
    //     if (confirm("确定要将'" + name + "'删除吗？")) {
    //         $.post("/lottery/deleteUser", {name: name}, function (msg) {
    //             if (msg != "success") {
    //                 alert("删除失败:" + msg);
    //             } else {
    //                 $this.remove();
    //                 location.reload();
    //                 countRewardNum();
    //             }
    //         })
    //     }
    // });

    function countRewardNum() {
        for (var i = 1; i < 6; i++) {
            var pList = $("#rewardType" + i).find(".person");
            $("#rewardType" + i).find(".person_num").eq(0).html('(' + pList.length + '人)')
        }
    }

})