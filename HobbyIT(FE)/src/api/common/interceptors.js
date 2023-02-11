import { useUserStore } from '@/store/user';
import axios from 'axios';
import { reissueRefreshToken } from '@/api';

// function getRefreshToken() {
//   try {
//     const {}
//   } catch (e) {
//
//   }
// };

function setInterceptors(instance) {
  const userStore = useUserStore();
  // 요청 인터셉터 추가하기
  instance.interceptors.request.use(
    function (config) {
      config.headers.Authorization = 'Bearer ' + userStore.getAccessToken;

      return config;
    },
    async function (error) {
      // 요청 오류가 있는 작업 수행
      const {
        config,
        response: { status },
      } = error;
      if (status === 401 && userStore.getRefreshToken && userStore.getAccessToken) {
        const originalRequest = config;
        const refreshToken = userStore.getRefreshToken;
        const data = {
          refreshToken,
        };
        const res = await reissueRefreshToken;
        console.log(res);
      }

      return Promise.reject(error);
    },
  );

  // 응답 인터셉터 추가하기
  instance.interceptors.response.use(
    function (response) {
      // 2xx 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
      // 응답 데이터가 있는 작업 수행
      return response;
    },
    function (error) {
      this;
      return Promise.reject(error);
    },
  );
  return instance;
}

function setInterceptorsWithNoAuth(instance) {
  // 요청 인터셉터 추가하기
  instance.interceptors.request.use(
    function (config) {
      return config;
    },
    function (error) {
      // 요청 오류가 있는 작업 수행
      return Promise.reject(error);
    },
  );

  // 응답 인터셉터 추가하기
  instance.interceptors.response.use(
    function (response) {
      // 2xx 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
      // 응답 데이터가 있는 작업 수행
      return response;
    },
    function (error) {
      // 2xx 외의 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
      // 응답 오류가 있는 작업 수행
      return Promise.reject(error);
    },
  );
  return instance;
}

export { setInterceptors, setInterceptorsWithNoAuth };