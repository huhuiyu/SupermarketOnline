(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('ManageMainCtrl', ['$scope', '$log', '$location', ManageMainCtrl]);

  function ManageMainCtrl($scope, $log, $location) {
    $log.debug('ManageMainCtrl init...', $location.path(), $location.search());

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('ManageMainCtrl destroy...');
    });

    //通过search参数控制包含页面
    //获取包含页面信息
    // var searchPage = $location.search().page;
    // var basePath = 'templates/manage/';
    // $scope.inc = searchPage ? basePath + searchPage :
    //   basePath + 'typemanage.html';

    // $scope.changePage = function (page) {
    //   $location.search({
    //     page: page + ".html"
    //   });
    //   $location.path($location.path());
    // };

    //通过hash参数控制包含页面，建议使用search方式
    var basePath = 'templates/manage/';
    $scope.hashPage = $location.hash();
    $scope.hashPage = $scope.hashPage ? $scope.hashPage : 'typemanage.html';
    $scope.inc = basePath + $scope.hashPage;

    $scope.changePage = function (page) {
      $location.hash(page + '.html');
      $location.path($location.path());
    };

  }
})();