# SSAFY 10기 공통 PJT - A507 Front-End README

## 1. FE 개발 환경

### 1.1. FE 기술 스택
```
vscode 1.85.1
node.js 20.10.0
npm 10.2.3
vue 3
vue/cli 5.0.8
vuetify 3 - vue cli (preview)
vue-router 4.2.5
pinia 2.1.7
prettier: 3.1.1
eslint: 7.32.0
axios: 1.6.5
toast-ui/editor: 3.2.2
pinia-plugin-persistedstate
```

### 1.2. FE 디자인
- Figma

### 1.3. FE 브랜치 전략
```
master
  ├── be-deploy
  │       .
  │       .
  │       .
  │
  └── fe-deploy
          └── fe-develop
                    ├── Feat_1
                    ├── Feat_2
                    └── Feat_3
                          .
                          .
                          .
```

- `master`에서 프론트/백엔드 프로젝트를 각각 배포하기 위해 `fe-deploy`와 `be-deploy`로 브랜치를 나누었습니다.
- 프론트엔드 프로젝트는 `fe-deploy`, `fe-develop`, `Feat`로 나누어 개발하였습니다
  - `fe-deploy`: 테스트가 완료된 단계에서 배포에만 사용하는 브랜치
  - `fe-develop`: 개발된 기능을 merge하고 테스트하는 브랜치
  - `Feat`: 기능 단위로 독립적인 환경에서 개발하는 브랜치
- `Feat`에서 개발을 마치면 `fe-develop`에 merge 후 테스트
- 이상이 없으면 `fe-deploy`에 merge함으로써 배포

### 1.4. 실행 방법
```
// 패키지 설치
npm i -f  // toast ui와 vue3의 호환성 문제로 인해 -f 옵션 필수

// 실행
npm run serve
```

<br/>
<br/>

## 2. FE 폴더 구조

```
frontend
  └── decode
      ├── node_modules
      ├── public
      ├── .env
      ├── package.json
      ├── package-lock.json
      └── src
            ├── plugins
            ├── utils
            ├── router
            ├── store
            ├── view
            └── components
                      ├── answer
                      ├── chat
                      ├── comment
                      ├── common
                      ├── main
                      ├── openvidu
                      ├── profile
                      ├── question
                      ├── rank
                      ├── shop
                      └── user
```

## 3. FE 역할 분담

### 정진영
- **UI**
  - 페이지
    - 메인 페이지
    - 질문게시판 페이지
    - 질문 상세 페이지
    - 질문 제목 생성 페이지
    - 질문 / 답변 생성 페이지
    - 질문 / 답변 수정 페이지
  - 컴포넌트
    - Navigation bar
    - 질문 검색 창
    - 마크다운 에디터: 질문 / 답변 작성 / 수정 시 사용(Toast Editor)
    - 마크다운 뷰어: 질문 / 답변 출력(Toast Viewer)
- **기능**
  - 질문
    - CRUD
    - 나도 궁금해요, 북마크
    - 질문 생성 / 수정 시 기술 스택 태그 추가/삭제
    - 질문 생성 시
      - 에러 코드 입력 시 GPT API를 통해 제목 및 관련 기술 태그 생성
    - 질문 제목 / 기술 태그로 검색
  - 답변
    - CRD
    - 추천, 채택
    - 질문 생성이 완료되면 GPT / Stackoverflow API를 통해 관련 답변 받기
  - 댓글
    - CRD


### 엄세원
- **UI**
  - 페이지
    - 로그인 페이지
    - 회원가입 페이지
    - 회원가입 시 기술스택 선택 페이지
    - 계정 / 비밀번호 찾기 페이지
    - 마이페이지
    - 회원정보 수정 페이지
  - 컴포넌트
    - Footer bar
    - 로그인 form
    - 회원가입 form
    - 회원정보
    - 작성한 질문,답변 / 팔로워 / 팔로잉 탭
- **기능**
  - 회원
    - 로그인
    - 회원가입 / 기술 스택 입력
    - 회원정보 / 기술 스택 수정
    - 계정 / 비밀번호 찾기
  - 소셜
    - 팔로우 / 팔로우 취소
  - 권한
    - 특정 페이지 로그인 없이 접근 제한 설정
    - 유효하지 않은 경로 접근 404 페이지 설정
  - 기타
    - 마크다운 에디터 폰트 플러그인


### 서재화
- **UI**
  - 컴포넌트
    - 채팅 모달
    - 화면 공유 컴포넌트
- **기능**
  - 채팅
  - 화면 공유


### 박우철
- **UI**
  - 컴포넌트
    - 출석 스트릭
    - 경험치 그래프
- **기능**
  - 회원
    - 출석 스트릭
    - 경험치
    - 기술 스택 수정
  - 기타
    - 마이페이지 코드 리팩토링


### 제선명
- **UI**
  - 페이지
    - 메인 페이지
    - 랭킹 페이지
  - 컴포넌트
    - 랭킹 검색창
    - 랭킹 테이블
  - 기타
    - 최종 UI 수정
- **기능**
  - 소셜
    - 경험치 / 티어 기능
    - 랭킹 검색 기능

<br/>
<br/>

## 4. 페이지 별 기능 소개

### 메인 페이지 - `제선명`. `정진영`
<img src="readmeimg/1_main.gif" height="200"/>
<br/>

- 서비스의 기능과 목적을 알 수 있습니다


### 회원가입 / 기술 스택 선택 페이지 - `엄세원`
<img src="readmeimg/2_signup_1.gif" height="200"/>
<br/>

- 회원가입을 진행할 수 있습니다.

<br/>
<img src="readmeimg/3_signup_2.gif" height="200"/>
<br/>

- 회원가입을 하면, 자신이 사용하거나 선호하는 기술 스택을 선택할 수 있습니다.

### 로그인 페이지 - `엄세원`
<img src="readmeimg/4_login.gif" height="200"/>
<br/>

- 로그인 페이지입니다. 깃허브 계정을 통한 로그인과 회원가입 또한 가능합니다.

### 질문 게시판 페이지 - `정진영`
<img src="readmeimg/5_board_search.gif" height="200"/>
<br/>

- 질문 게시판입니다. 코딩하다 마주친 에러나 궁금한 점에 대해 자유롭게 질문을 등록할 수 있습니다.
- 검색을 통해서 이미 누군가가 올린 질문과 답변을 찾을 수 있습니다.

### 질문 제목 / 질문 생성 페이지 - `정진영`
<img src="readmeimg/6_create_title.gif" height="200"/>
<br/>

- 코딩하다 마주친 에러, 궁금한 점을 입력하면, GPT가 제목과 관련 태그를 자동 생성해줍니다.

<br/>
<img src="readmeimg/7_1_create_question.gif" height="200"/>
<br/>
<br/>
<img src="readmeimg/7_2_gpt_sof_answer.gif" height="200"/>
<br/>

- 자동 생성된 태그의 버전을 입력하고, 질문 사항을 적으면 질문이 생성됩니다.
- 질문은 마크다운 에디터를 통해 원하는 형식으로 입력 가능합니다.
- 질문 생성이 완료되면, GPT 생성 답변과 Stackoverflow의 유사 질문에 대한 답변을 받을 수 있습니다.
- 위 사진은, 질문을 생성했을 때 받은 GPT의 답변과, Stackoverflow의 유사 질문에 대한 답변의 예시입니다.
<br/>
<br/>

### 질문 상세 페이지 - `정진영`
<img src="readmeimg/8_detail.gif" height="200"/>
<br/>

- 사용자들이 게시한 질문의 내용과 기술 태그, 버전을 확인할 수 있습니다.
- 마크다운 뷰어를 통해, 사용자가 작성한 마크다운 형식으로 출력해줍니다.
- 질문의 수정 / 삭제가 가능합니다.
- 해당 페이지에서 위와 같이 답변과 댓글을 남기고 확인할 수 있습니다.
- 사용자들은 질문에 대해 나도 궁금해요, 북마크의 기능을 사용할 수 있습니다. 답변이 채택되면, 나도 궁금해요를 눌렀던 사용자들에게 메일을 발송하여 알려줍니다.

<br/>
<img src="readmeimg/11_comment_create.gif" height="200"/>
<br/>

- 댓글을 생성한 예시입니다.


### 질문 수정 페이지 - `정진영`
<img src="readmeimg/9_question_update.gif" height="200"/>
<br/>

- 질문 상세페이지에서 질문을 수정할 수 있습니다.

<br/>


### 답변 생성 - `정진영`
<img src="readmeimg/10_answer_create.gif" height="200"/>
<br/>

- 질문 상세 페이지에서 사용자들이 직접 답변을 남길 수 있습니다.
- 답변 또한 질문과 같이 마크다운 형식으로 작성할 수 있습니다.


<img src="readmeimg/12_chatroom_create.gif" height="200"/>
<br/>



### 채팅방 / 화면 공유 - `서재화`
<img src="readmeimg/13_chatting.gif" height="200"/>
<br/>

- 우측 하단의 아이콘을 누르면 채팅방의 목록을 확인하고 채팅방을 생성할 수 있습니다.

<br/>
<img src="readmeimg/14_1_screen_share.gif" height="200"/>
<br/>
<br/>
<img src="readmeimg/14_2_screen_share.gif" height="200"/>
<br/>

- 채팅으로 설명이 부족할 땐, 화면 공유를 통해 더욱 원활한 소통이 가능합니다.
- 화면 공유를 하는 중에도 음성 대화, 채팅 또한 가능합니다.


<br/>
<br/>

### 랭킹 페이지 - `제선명`
<img src="readmeimg/15_rank_search.gif" height="200"/>
<br/>

- 사용자의 경험치, 티어, 랭킹을 확인할 수 있습니다.
- 사용자 검색을 할 수 있습니다.

<br/>
<br/>

### 마이 페이지 - `엄세원`, `박우철`
<img src="readmeimg/16_1_mypage_tab.gif" height="200"/>
<br/>

- 사용자와 관련된 정보들을 볼 수 있습니다.
- 화면 상단에서는 기술 스택, 출석 스트릭, 경험치 변동 추이를 볼 수 있습니다.
- 하단부에 있는 탭을 통해서는 사용자가 남긴 질문, 답변을 남긴 질문 목록과 함께 팔로워 / 팔로잉 목록을 확인할 수 있습니다.
- 다른 사용자의 페이지도 동일한 형식으로 이루어져 있습니다.

<br/>

<img src="readmeimg/16_2_follow.gif" height="200"/>
<br/>

- 사용자 간 팔로우가 가능합니다.

<br/>

<img src="readmeimg/17_mypage_update_stack.gif" height="200"/>
<br/>

- 화면 상단부에서 사용자의 기술 스택을 변경할 수 있습니다.

<br/>



<img src="readmeimg/18_update_profile.gif" height="200"/>
<br/>

- 회원정보 수정 버튼을 통해 회원 정보 수정 페이지로 이동할 수 있습니다.

<br/>


## 5. FE 트러블 슈팅
### 5.1. 컴포넌트 명칭 오류

  - 컴포넌트의 명칭이 한 단어로 되어있을 경우 오류가 뜹니다.
  - Vue에서는 컴포넌트명을 2가지 이상의 단어로 조합하기를 권장하고 있습니다.
  - 해결방안: ESLint 설정을 `vue.config.js` 파일에서 `lintOnSave:false`로 변경해주고 서버를 재기동했습니다.

    ```javascript
    const { defineConfig } = require('@vue/cli-service');
    module.exports = defineConfig({
      transpileDependencies: true,
      lintOnSave: false,
    });
    ```

### 5.2. port 충돌
  - FE와 BE 서버가 함께 켜지지 않는 문제가 발생했습니다.
  - 같은 포트를 사용하고 있는 것을 발견하였습니다.
  - 해결방안: FE의 포트 번호를 변경하였습니다.

### 5.3. router 관련 에러
  - `'/router'`의 `router.js`를 읽어들이는 과정에서 오류 발생하였습니다.
  - 파일명이 `index.js`였으면 해당 경로 사용가능하지만, 파일명이 `router.js`라서 생긴 오류였습니다.
  - 해결방안: 파일명을 `'index.js'`로 바꿔서 해결하였습니다.

### 5.4. 이미지 경로 문제
  - vue-cli 프로젝트에서 src > assets 폴더에 있는 이미지 경로를 불러오지 못하는 현상이 있었습니다.
  - 일반적인 vue 프로젝트와 다른 방식으로 이미지를 불러와야 한다는 사실을 알게 되었습니다.
  - 해결방안: 정적 파일에 접근할 경우 Web Server 파일 접근 방식을 이용할 수 있습니다.
  ```html
  <img src="./LogoDecode3.png" alt="로고">
  ```
  - vue - cli의 정적 파일은 public 폴더에 담겨 있기 때문에 바로 볼 수 있게 합니다.

### 5.5. toast ui 이미지 삽입 시 링크 길이
  - 게시글 작성 시 이미지를 삽입했을 때, base64로 인코딩하여 굉장히 긴 경로를 반환하였습니다.
  - 해결방안: 이미지를 올렸을 때, AWS S3에 이미지가 저장되도록 하고, 저장된 URL를 response로 받아오도록 하여 해결하였습니다.

  ```javascript
  export default {
    data() {
      return {
        editor: null,
      };
    },

    mounted() {
      const questionStore = useQuestionStore();
      this.editor = new Editor({
        el: document.querySelector('#editor'),
        height: '570px',
        initialEditType: 'markdown',
        initialValue:
          '```\n' +
          questionStore.inputQuestionContent +
          '\n```' +
          '\n\n내용을 마크다운 형식으로 입력해주세요!\n질문을 등록하면 GPT의 답변을 자동으로 받아볼 수 있습니다. :)',
        previewStyle: 'vertical',
        hooks: {
          addImageBlobHook: addImageBlobHook,
        },
        plugins: [colorSyntax, fontSize],
      });

      this.editor.on('change', () => {
        // 변경된 내용을 부모 컴포넌트로 전달
        this.$emit('editor-content-updated', this.editor.getMarkdown());
      });
    },
  };

  const addImageBlobHook = async (blob, callback) => {
    const formData = new FormData();
    formData.append('file', blob);

    await axios
      .post('/image', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      })
      .then((res) => {
        const uploadURL = res.data.data.url;
        callback(uploadURL, '사진');
      })
      .catch((e) => {
        callback('', '이미지 업로드 실패');
      });
  };
  ```

### 5.6. onMounted가 곧바로 렌더링되지 않던 현상
  - 마이페이지 화면에 입장하는 순간 곧바로 data가 렌더링되지 않는 문제가 발생했습니다.
  - 해당 부분만 `MyProfileWindow.vue`로 따로 분리하여 `MyProfile.vue` 맨 하단에 `<MyProfileWindow />`로 작성해 자식 컴포넌트처럼 구성해보기도 했지만 결과는 같았습니다.
  - 해결방안: 렌더링 순서만 바꾸면 되지 않겠나 하는 생각에 `onMounted`를 `onBeforeMount`로 수정했는데 해결이 되었습니다.

