// Composables
import { createRouter, createWebHistory } from 'vue-router';
import { useUserStore } from '@/store/user';

const routes = [
  {
    path: '/',
    component: () => import('@/layouts/default/HomeDefault.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        component: () => import('@/views/Home.vue'),
      },
    ],
  },
  // 모달을 위한
  {
    path: '/router',
    component: () => import('@/layouts/default/HomeDefault.vue'),
    children: [
      {
        path: '',
        name: 'Modal',
        component: () => import('@/views/Modal.vue'),
      },
    ],
  },
  //
  {
    path: '/signup',
    component: () => import('@/layouts/default/HomeDefault.vue'),
    children: [
      {
        path: '',
        name: 'signup',
        component: () => import('@/views/Signup.vue'),
      },
    ],
  },
  {
    path: '/login',
    component: () => import('@/layouts/default/HomeDefault.vue'),
    children: [
      {
        path: '',
        name: 'login',
        component: () => import('@/views/LogIn.vue'),
      },
    ],
  },
  {
    path: '/resetPassword',
    component: () => import('@/layouts/default/HomeDefault.vue'),
    children: [
      {
        path: '',
        name: 'resetPassword',
        component: () => import('@/views/resetPassword.vue'),
      },
    ],
  },
  {
    path: '/about',
    component: () => import('@/layouts/default/MainPage.vue'),
    children: [
      {
        path: '',
        name: 'about',
        component: () => import('@/views/GuideView.vue'),
      },
    ],
  },
  {
    path: '/main',
    component: () => import('@/layouts/default/MainPage.vue'),
    meta: { requiresAuth: true },
    children: [
      {
        path: '',
        name: 'Main',
        component: () => import('@/views/MainView.vue'),
      },
    ],
  },
  {
    path: '/promo',
    component: () => import('@/layouts/default/MainPage.vue'),
    meta: { requiresAuth: true },
    children: [
      {
        path: '',
        name: 'promo',
        component: () => import('@/views/PromoPageView.vue'),
      },
    ],
  },
  {
    path: '/mypage',
    component: () => import('@/layouts/default/MainPage.vue'),
    children: [
      {
        path: ':nickname',
        name: 'MyPage',
        component: () => import('@/views/MypageView.vue'),
      },
    ],
  },
  {
    path: '/group',
    component: () => import('@/layouts/default/HomeDefault.vue'),
    children: [
      {
        path: '',
        name: 'Grouppage',
        component: () => import('@/views/GroupView.vue'),
        children: [
          {
            path: ':id/videochat',
            component: () => import('@/views/VideoChat.vue'),
            name: 'VideoChat',
            meta: { isGroupUser: true },
            props : true
          },
          {
            path: ':id',
            name: 'GroupMainPage',
            component: () => import('@/views/GroupPageView.vue'),
          },
        ],
      },
    ],
  },
  {
    path: '/404',
    name: 'NotFound',
    component: () => import('@/views/NotFound.vue'),
  },
  {
    path: '/:pathMathch(.*)*',
    redirect: '/404',
    // notfound!
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});
router.beforeEach((to, from) => {
  const userStore = useUserStore();
  document.documentElement.scrollTop = 0;
  if (to.name !== 'Home' && !from.name) {
    return { name: 'Home' };
  }
  if (to.meta.requiresAuth && !userStore.isLoggedIn) {
    return { name: 'login' };
  }
  return true;
});

export default router;
