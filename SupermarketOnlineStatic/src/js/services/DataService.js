/**
 * 数据服务
 */
(function () {
  var app = angular.module(MyAppConfig.services);

  app.factory('DataService', ['$log', '$http', '$timeout', '$location', 'MyCookieService', 'MyUtilService', 'DialogService', DataService]);

  function DataService($log, $http, $timeout, $location, MyCookieService, MyUtilService, DialogService) {
    $log.info('DataService init...');
    var errorInfo = {
      success: false,
      message: '请检查网络状态',
      code: 404
    };

    var service = {
      dataServer: ''
    };

    service.setDataServer = function (dataServer) {
      service.dataServer = dataServer;
    };
    var servertokenKey = 'servertoken.key';

    service.send = function (url, postdata, cb) {
      if (!postdata) {
        postdata = {};
      }
      // 发送时间戳
      postdata.ajaxtimestamp = new Date().getTime();
      postdata.token = MyCookieService.getLocalData(servertokenKey);
      $http({
        method: 'POST',
        url: service.dataServer + url,
        data: postdata
      }).then(
        function (data, status) {
          $log.debug(data, status);
          //处理服务器token
          if (data.data && data.data.token && !MyUtilService.empty(MyUtilService.trim(data.data.token))) {
            MyCookieService.putLocalData(servertokenKey, data.data.token);
          }
          //统一处理需要登录的情况
          if (data.data && data.data.code == 1000) {
            DialogService.hideWait();
            //需要管理登录的情况
            DialogService.showAlert(data.data.message, function () {
              $timeout(function () {
                //清除地址栏参数，跳转到登录
                $location.search({});
                $location.hash('');
                $location.path('/route/page/manage/index');
              }, 1);
            });
            return;
          }
          (cb || angular.noop)(data.data);
        },
        function (data, status) {
          $log.error('DataService.send error:', data);
          (cb || angular.noop)(errorInfo);
        }
      );
    };

    service.get = function (url, cb) {
      $http({
        method: 'GET',
        url: url
      }).then(
        function (data, status) {
          $log.info(data, '====>', status);
          (cb || angular.noop)(null, data.data);
        },
        function (data, status) {
          $log.error(data);
          (cb || angular.noop)(data, null);
        }
      );
    };

    service.post = function (url, postdata, cb) {
      $http({
        method: 'POST',
        url: url,
        data: postdata
      }).then(
        function (data, status) {
          $log.debug(data, status);
          (cb || angular.noop)(null, data.data);
        },
        function (data, status) {
          $log.error('DataService.send error:', data);
          (cb || angular.noop)(data, null);
        }
      );
    };

    return service;
  }
})();