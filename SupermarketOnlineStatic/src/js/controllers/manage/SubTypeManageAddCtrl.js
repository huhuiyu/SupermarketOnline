(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('SubTypeManageAddCtrl', ['$scope', '$log', 'DialogService', 'DataService', SubTypeManageAddCtrl]);

  function SubTypeManageAddCtrl($scope, $log, DialogService, DataService) {
    $log.debug('SubTypeManageAddCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('SubTypeManageAddCtrl destroy...');
    });

    var cdata = DialogService.getCustomData();
    $scope.types = [{
      tid: -1,
      typeName: '-----请选择分类-----'
    }].concat(cdata.types);

    $scope.formdata = {
      tid: $scope.types[0].tid
    };

    $scope.close = function () {
      DialogService.hideCustom();
    };

  }
})();