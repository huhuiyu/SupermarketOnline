(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('TestMyTestCtrl', ['$scope', '$log', 'DialogService', 'DataService', 'MyUtilService', TestMyTestCtrl]);

  function TestMyTestCtrl($scope, $log, DialogService, DataService, MyUtilService) {
    $log.debug('TestMyTestCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('TestMyTestCtrl destroy...');
    });

    DialogService.showWait('获取后台数据中');
    DataService.send('/', {
      echo: new Date().getTime()
    }, function (data) {
      DialogService.hideWait();
      var info = MyUtilService.trustAsHtml(
        MyUtilService.jsonSyntaxHighlight(JSON.stringify(data)));
      $log.debug('info===>', info);
      DialogService.showAlert(info);
    });
  }
})();