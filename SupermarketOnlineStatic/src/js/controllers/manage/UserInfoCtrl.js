(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('ManageUserInfoCtrl', ['$scope', '$log', 'DataService', 'DialogService', ManageUserInfoCtrl]);

  function ManageUserInfoCtrl($scope, $log, DataService, DialogService) {
    $log.debug('ManageUserInfoCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('ManageUserInfoCtrl destroy...');
    });

    $scope.queryUser = function () {
      DataService.send('/admin/user/getUserInfo', {}, function (data) {
        $scope.userinfo = data.datas.user;
      });
    };

    $scope.queryUser();

    $scope.logout = function () {
      DialogService.showWait('安全退出中，请稍候...');
      DataService.send('/admin/user/logout', {}, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message, function () {
          //不推荐使用原始方式跳转
          location = '/#!/route/page/manage/index';
        });
      });
    };


  }
})();