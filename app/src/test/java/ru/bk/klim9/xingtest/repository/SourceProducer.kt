package ru.bk.klim9.xingtest.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.bk.klim9.xingtest.requests.repos.RepoResponse
import ru.bk.klim9.xingtest.requests.repos.ReposItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/23/21
 */
object SourceProducer {

    fun createFulReposItemlList(): List<ReposItem> = arrayListOf<ReposItem>().apply {
        add(ReposItem("TestName1", "OwnerLogin1", "ownerLogo1", "description1", true))
        add(ReposItem("TestName2", "OwnerLogin2", "ownerLogo2", "description2", true))
        add(ReposItem("TestName3", "OwnerLogin3", "ownerLogo3", "description3", true))
        add(ReposItem("TestName4", "OwnerLogin4", "ownerLogo4", "description4", true))

    }

    fun getFullRepoResponse(): RepoResponse {
        val type = object : TypeToken<RepoResponse>() {}.type
        return Gson().fromJson(repoResponseJson, type)
    }

    private const val repoResponseJson = "[\n" +
            "  {\n" +
            "    \"id\": 234107,\n" +
            "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkyMzQxMDc=\",\n" +
            "    \"name\": \"gearman-ruby\",\n" +
            "    \"full_name\": \"xing/gearman-ruby\",\n" +
            "    \"private\": false,\n" +
            "    \"owner\": {\n" +
            "      \"login\": \"xing\",\n" +
            "      \"id\": 27901,\n" +
            "      \"node_id\": \"MDEyOk9yZ2FuaXphdGlvbjI3OTAx\",\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/27901?v=4\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/xing\",\n" +
            "      \"html_url\": \"https://github.com/xing\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/xing/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/xing/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/xing/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/xing/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/xing/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/xing/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/xing/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/xing/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/xing/received_events\",\n" +
            "      \"type\": \"Organization\",\n" +
            "      \"site_admin\": false\n" +
            "    },\n" +
            "    \"html_url\": \"https://github.com/xing/gearman-ruby\",\n" +
            "    \"description\": \"Ruby library for the Gearman distributed job system\",\n" +
            "    \"fork\": true,\n" +
            "    \"url\": \"https://api.github.com/repos/xing/gearman-ruby\",\n" +
            "    \"forks_url\": \"https://api.github.com/repos/xing/gearman-ruby/forks\",\n" +
            "    \"keys_url\": \"https://api.github.com/repos/xing/gearman-ruby/keys{/key_id}\",\n" +
            "    \"collaborators_url\": \"https://api.github.com/repos/xing/gearman-ruby/collaborators{/collaborator}\",\n" +
            "    \"teams_url\": \"https://api.github.com/repos/xing/gearman-ruby/teams\",\n" +
            "    \"hooks_url\": \"https://api.github.com/repos/xing/gearman-ruby/hooks\",\n" +
            "    \"issue_events_url\": \"https://api.github.com/repos/xing/gearman-ruby/issues/events{/number}\",\n" +
            "    \"events_url\": \"https://api.github.com/repos/xing/gearman-ruby/events\",\n" +
            "    \"assignees_url\": \"https://api.github.com/repos/xing/gearman-ruby/assignees{/user}\",\n" +
            "    \"branches_url\": \"https://api.github.com/repos/xing/gearman-ruby/branches{/branch}\",\n" +
            "    \"tags_url\": \"https://api.github.com/repos/xing/gearman-ruby/tags\",\n" +
            "    \"blobs_url\": \"https://api.github.com/repos/xing/gearman-ruby/git/blobs{/sha}\",\n" +
            "    \"git_tags_url\": \"https://api.github.com/repos/xing/gearman-ruby/git/tags{/sha}\",\n" +
            "    \"git_refs_url\": \"https://api.github.com/repos/xing/gearman-ruby/git/refs{/sha}\",\n" +
            "    \"trees_url\": \"https://api.github.com/repos/xing/gearman-ruby/git/trees{/sha}\",\n" +
            "    \"statuses_url\": \"https://api.github.com/repos/xing/gearman-ruby/statuses/{sha}\",\n" +
            "    \"languages_url\": \"https://api.github.com/repos/xing/gearman-ruby/languages\",\n" +
            "    \"stargazers_url\": \"https://api.github.com/repos/xing/gearman-ruby/stargazers\",\n" +
            "    \"contributors_url\": \"https://api.github.com/repos/xing/gearman-ruby/contributors\",\n" +
            "    \"subscribers_url\": \"https://api.github.com/repos/xing/gearman-ruby/subscribers\",\n" +
            "    \"subscription_url\": \"https://api.github.com/repos/xing/gearman-ruby/subscription\",\n" +
            "    \"commits_url\": \"https://api.github.com/repos/xing/gearman-ruby/commits{/sha}\",\n" +
            "    \"git_commits_url\": \"https://api.github.com/repos/xing/gearman-ruby/git/commits{/sha}\",\n" +
            "    \"comments_url\": \"https://api.github.com/repos/xing/gearman-ruby/comments{/number}\",\n" +
            "    \"issue_comment_url\": \"https://api.github.com/repos/xing/gearman-ruby/issues/comments{/number}\",\n" +
            "    \"contents_url\": \"https://api.github.com/repos/xing/gearman-ruby/contents/{+path}\",\n" +
            "    \"compare_url\": \"https://api.github.com/repos/xing/gearman-ruby/compare/{base}...{head}\",\n" +
            "    \"merges_url\": \"https://api.github.com/repos/xing/gearman-ruby/merges\",\n" +
            "    \"archive_url\": \"https://api.github.com/repos/xing/gearman-ruby/{archive_format}{/ref}\",\n" +
            "    \"downloads_url\": \"https://api.github.com/repos/xing/gearman-ruby/downloads\",\n" +
            "    \"issues_url\": \"https://api.github.com/repos/xing/gearman-ruby/issues{/number}\",\n" +
            "    \"pulls_url\": \"https://api.github.com/repos/xing/gearman-ruby/pulls{/number}\",\n" +
            "    \"milestones_url\": \"https://api.github.com/repos/xing/gearman-ruby/milestones{/number}\",\n" +
            "    \"notifications_url\": \"https://api.github.com/repos/xing/gearman-ruby/notifications{?since,all,participating}\",\n" +
            "    \"labels_url\": \"https://api.github.com/repos/xing/gearman-ruby/labels{/name}\",\n" +
            "    \"releases_url\": \"https://api.github.com/repos/xing/gearman-ruby/releases{/id}\",\n" +
            "    \"deployments_url\": \"https://api.github.com/repos/xing/gearman-ruby/deployments\",\n" +
            "    \"created_at\": \"2009-06-23T08:02:08Z\",\n" +
            "    \"updated_at\": \"2019-03-08T09:53:02Z\",\n" +
            "    \"pushed_at\": \"2013-08-07T03:19:40Z\",\n" +
            "    \"git_url\": \"git://github.com/xing/gearman-ruby.git\",\n" +
            "    \"ssh_url\": \"git@github.com:xing/gearman-ruby.git\",\n" +
            "    \"clone_url\": \"https://github.com/xing/gearman-ruby.git\",\n" +
            "    \"svn_url\": \"https://github.com/xing/gearman-ruby\",\n" +
            "    \"homepage\": \"http://gearman.org/\",\n" +
            "    \"size\": 280,\n" +
            "    \"stargazers_count\": 7,\n" +
            "    \"watchers_count\": 7,\n" +
            "    \"language\": \"Ruby\",\n" +
            "    \"has_issues\": true,\n" +
            "    \"has_projects\": true,\n" +
            "    \"has_downloads\": true,\n" +
            "    \"has_wiki\": true,\n" +
            "    \"has_pages\": false,\n" +
            "    \"forks_count\": 2,\n" +
            "    \"mirror_url\": null,\n" +
            "    \"archived\": true,\n" +
            "    \"disabled\": false,\n" +
            "    \"open_issues_count\": 0,\n" +
            "    \"license\": {\n" +
            "      \"key\": \"mit\",\n" +
            "      \"name\": \"MIT License\",\n" +
            "      \"spdx_id\": \"MIT\",\n" +
            "      \"url\": \"https://api.github.com/licenses/mit\",\n" +
            "      \"node_id\": \"MDc6TGljZW5zZTEz\"\n" +
            "    },\n" +
            "    \"forks\": 2,\n" +
            "    \"open_issues\": 0,\n" +
            "    \"watchers\": 7,\n" +
            "    \"default_branch\": \"master\",\n" +
            "    \"permissions\": {\n" +
            "      \"admin\": false,\n" +
            "      \"push\": false,\n" +
            "      \"pull\": true\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 240669,\n" +
            "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkyNDA2Njk=\",\n" +
            "    \"name\": \"gearman-server\",\n" +
            "    \"full_name\": \"xing/gearman-server\",\n" +
            "    \"private\": false,\n" +
            "    \"owner\": {\n" +
            "      \"login\": \"xing\",\n" +
            "      \"id\": 27901,\n" +
            "      \"node_id\": \"MDEyOk9yZ2FuaXphdGlvbjI3OTAx\",\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/27901?v=4\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/xing\",\n" +
            "      \"html_url\": \"https://github.com/xing\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/xing/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/xing/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/xing/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/xing/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/xing/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/xing/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/xing/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/xing/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/xing/received_events\",\n" +
            "      \"type\": \"Organization\",\n" +
            "      \"site_admin\": false\n" +
            "    },\n" +
            "    \"html_url\": \"https://github.com/xing/gearman-server\",\n" +
            "    \"description\": \"Gearman C Server\",\n" +
            "    \"fork\": false,\n" +
            "    \"url\": \"https://api.github.com/repos/xing/gearman-server\",\n" +
            "    \"forks_url\": \"https://api.github.com/repos/xing/gearman-server/forks\",\n" +
            "    \"keys_url\": \"https://api.github.com/repos/xing/gearman-server/keys{/key_id}\",\n" +
            "    \"collaborators_url\": \"https://api.github.com/repos/xing/gearman-server/collaborators{/collaborator}\",\n" +
            "    \"teams_url\": \"https://api.github.com/repos/xing/gearman-server/teams\",\n" +
            "    \"hooks_url\": \"https://api.github.com/repos/xing/gearman-server/hooks\",\n" +
            "    \"issue_events_url\": \"https://api.github.com/repos/xing/gearman-server/issues/events{/number}\",\n" +
            "    \"events_url\": \"https://api.github.com/repos/xing/gearman-server/events\",\n" +
            "    \"assignees_url\": \"https://api.github.com/repos/xing/gearman-server/assignees{/user}\",\n" +
            "    \"branches_url\": \"https://api.github.com/repos/xing/gearman-server/branches{/branch}\",\n" +
            "    \"tags_url\": \"https://api.github.com/repos/xing/gearman-server/tags\",\n" +
            "    \"blobs_url\": \"https://api.github.com/repos/xing/gearman-server/git/blobs{/sha}\",\n" +
            "    \"git_tags_url\": \"https://api.github.com/repos/xing/gearman-server/git/tags{/sha}\",\n" +
            "    \"git_refs_url\": \"https://api.github.com/repos/xing/gearman-server/git/refs{/sha}\",\n" +
            "    \"trees_url\": \"https://api.github.com/repos/xing/gearman-server/git/trees{/sha}\",\n" +
            "    \"statuses_url\": \"https://api.github.com/repos/xing/gearman-server/statuses/{sha}\",\n" +
            "    \"languages_url\": \"https://api.github.com/repos/xing/gearman-server/languages\",\n" +
            "    \"stargazers_url\": \"https://api.github.com/repos/xing/gearman-server/stargazers\",\n" +
            "    \"contributors_url\": \"https://api.github.com/repos/xing/gearman-server/contributors\",\n" +
            "    \"subscribers_url\": \"https://api.github.com/repos/xing/gearman-server/subscribers\",\n" +
            "    \"subscription_url\": \"https://api.github.com/repos/xing/gearman-server/subscription\",\n" +
            "    \"commits_url\": \"https://api.github.com/repos/xing/gearman-server/commits{/sha}\",\n" +
            "    \"git_commits_url\": \"https://api.github.com/repos/xing/gearman-server/git/commits{/sha}\",\n" +
            "    \"comments_url\": \"https://api.github.com/repos/xing/gearman-server/comments{/number}\",\n" +
            "    \"issue_comment_url\": \"https://api.github.com/repos/xing/gearman-server/issues/comments{/number}\",\n" +
            "    \"contents_url\": \"https://api.github.com/repos/xing/gearman-server/contents/{+path}\",\n" +
            "    \"compare_url\": \"https://api.github.com/repos/xing/gearman-server/compare/{base}...{head}\",\n" +
            "    \"merges_url\": \"https://api.github.com/repos/xing/gearman-server/merges\",\n" +
            "    \"archive_url\": \"https://api.github.com/repos/xing/gearman-server/{archive_format}{/ref}\",\n" +
            "    \"downloads_url\": \"https://api.github.com/repos/xing/gearman-server/downloads\",\n" +
            "    \"issues_url\": \"https://api.github.com/repos/xing/gearman-server/issues{/number}\",\n" +
            "    \"pulls_url\": \"https://api.github.com/repos/xing/gearman-server/pulls{/number}\",\n" +
            "    \"milestones_url\": \"https://api.github.com/repos/xing/gearman-server/milestones{/number}\",\n" +
            "    \"notifications_url\": \"https://api.github.com/repos/xing/gearman-server/notifications{?since,all,participating}\",\n" +
            "    \"labels_url\": \"https://api.github.com/repos/xing/gearman-server/labels{/name}\",\n" +
            "    \"releases_url\": \"https://api.github.com/repos/xing/gearman-server/releases{/id}\",\n" +
            "    \"deployments_url\": \"https://api.github.com/repos/xing/gearman-server/deployments\",\n" +
            "    \"created_at\": \"2009-07-01T13:36:57Z\",\n" +
            "    \"updated_at\": \"2019-03-08T09:26:53Z\",\n" +
            "    \"pushed_at\": \"2009-07-28T10:27:22Z\",\n" +
            "    \"git_url\": \"git://github.com/xing/gearman-server.git\",\n" +
            "    \"ssh_url\": \"git@github.com:xing/gearman-server.git\",\n" +
            "    \"clone_url\": \"https://github.com/xing/gearman-server.git\",\n" +
            "    \"svn_url\": \"https://github.com/xing/gearman-server\",\n" +
            "    \"homepage\": \"http://www.gearman.org\",\n" +
            "    \"size\": 926,\n" +
            "    \"stargazers_count\": 3,\n" +
            "    \"watchers_count\": 3,\n" +
            "    \"language\": \"C\",\n" +
            "    \"has_issues\": false,\n" +
            "    \"has_projects\": true,\n" +
            "    \"has_downloads\": true,\n" +
            "    \"has_wiki\": true,\n" +
            "    \"has_pages\": false,\n" +
            "    \"forks_count\": 5,\n" +
            "    \"mirror_url\": null,\n" +
            "    \"archived\": true,\n" +
            "    \"disabled\": false,\n" +
            "    \"open_issues_count\": 0,\n" +
            "    \"license\": {\n" +
            "      \"key\": \"other\",\n" +
            "      \"name\": \"Other\",\n" +
            "      \"spdx_id\": \"NOASSERTION\",\n" +
            "      \"url\": null,\n" +
            "      \"node_id\": \"MDc6TGljZW5zZTA=\"\n" +
            "    },\n" +
            "    \"forks\": 5,\n" +
            "    \"open_issues\": 0,\n" +
            "    \"watchers\": 3,\n" +
            "    \"default_branch\": \"master\",\n" +
            "    \"permissions\": {\n" +
            "      \"admin\": false,\n" +
            "      \"push\": false,\n" +
            "      \"pull\": true\n" +
            "    }\n" +
            "  }\n" +
            "]"
}