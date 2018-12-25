(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('ManageIndexCtrl', ['$scope', '$log', '$location', '$timeout', 'DialogService', 'DataService', ManageIndexCtrl]);

  function ManageIndexCtrl($scope, $log, $location, $timeout, DialogService, DataService) {
    $log.debug('ManageIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('ManageIndexCtrl destroy...');
    });

    $scope.formdata = {};

    $scope.login = function () {
      DialogService.showWait('登录中，请稍候...');
      DataService.send('/admin/user/login', {
        user: $scope.formdata
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message, function () {
          if (data.success) {
            $timeout(function () {
              $location.hash('typemanage.html');
              $location.path('/route/page/manage/main');
            }, 1);
          }
        });
      });

    };
  }
})();