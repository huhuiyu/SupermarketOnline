(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('ManageIndexCtrl', ['$scope', '$log', ManageIndexCtrl]);

  function ManageIndexCtrl($scope, $log) {
    $log.debug('ManageIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('ManageIndexCtrl destroy...');
    });
  }
})();
