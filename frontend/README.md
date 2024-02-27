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


## 4. FE 트러블 슈팅
### 4.1. 컴포넌트 명칭 오류

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

### 4.2. port 충돌
  - FE와 BE 서버가 함께 켜지지 않는 문제가 발생했습니다.
  - 같은 포트를 사용하고 있는 것을 발견하였습니다.
  - 해결방안: FE의 포트 번호를 변경하였습니다.

### 4.3. router 관련 에러
  - `'/router'`의 `router.js`를 읽어들이는 과정에서 오류 발생하였습니다.
  - 파일명이 `index.js`였으면 해당 경로 사용가능하지만, 파일명이 `router.js`라서 생긴 오류였습니다.
  - 해결방안: 파일명을 `'index.js'`로 바꿔서 해결하였습니다.

### 4.4. 이미지 경로 문제
  - vue-cli 프로젝트에서 src > assets 폴더에 있는 이미지 경로를 불러오지 못하는 현상이 있었습니다.
  - 일반적인 vue 프로젝트와 다른 방식으로 이미지를 불러와야 한다는 사실을 알게 되었습니다.
  - 해결방안: 정적 파일에 접근할 경우 Web Server 파일 접근 방식을 이용할 수 있습니다.
  ```html
  <img src="./LogoDecode3.png" alt="로고">
  ```
  - vue - cli의 정적 파일은 public 폴더에 담겨 있기 때문에 바로 볼 수 있게 합니다.

### 4.5. toast ui 이미지 삽입 시 링크 길이
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

### 4.6. onMounted가 곧바로 렌더링되지 않던 현상
  - 마이페이지 화면에 입장하는 순간 곧바로 data가 렌더링되지 않는 문제가 발생했습니다.
  - 해당 부분만 `MyProfileWindow.vue`로 따로 분리하여 `MyProfile.vue` 맨 하단에 `<MyProfileWindow />`로 작성해 자식 컴포넌트처럼 구성해보기도 했지만 결과는 같았습니다.
  - 해결방안: 렌더링 순서만 바꾸면 되지 않겠나 하는 생각에 `onMounted`를 `onBeforeMount`로 수정했는데 해결이 되었습니다.

