import Vue from "vue";
import VueRouter from "vue-router";

import main from "@/router/modules/main";
import meeting from "@/router/modules/meeting";
import error from "@/router/modules/error";

import store from "@/store";

Vue.use(VueRouter);

const routes = [...main, ...meeting, ...error];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
});

router.beforeEach((to, from, next) => {
  const access_token = localStorage.getItem("Authorization");
  // console.log("Before", access_token, from, to);
  store.dispatch("memberStore/isLogin");

  if (access_token) {
    next();
  } else if (to.name === "landing" || to.name === "login") {
    //login page를 가거나 login이 성공 됐을 때는 다음으로 넘어감
    next();
  } else if (to.name === "meeting") {
    const meetingId = to.params.id;
    alert(meetingId);
    next({
      name: "login",
    });
  } else {
    //그 외에 모든 경로는 login으로
    next({
      name: "login",
    });
  }
});

export default router;
